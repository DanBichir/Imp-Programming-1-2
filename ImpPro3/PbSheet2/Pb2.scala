package solutions

object pb2{

trait Command[T] {
    def execute(target: T): Option[Change]
}
trait Change {
    def undo(): Unit
}

/* State: balance: Int */ // Init?
trait Account {
    // Post: balance = balance0 + amount
    def deposit(amount: Int)

    // Post: if amount <= balance then balance = balance0 - amount
    //                            else balance = balance0
    def withdraw(amount: Int): Boolean

    // Post: balance = balance0 and
    //                 returns balance
    def balance: Int
}

class BasicAccount(private var _balance: Int) extends Account {
    def deposit(amount: Int) = _balance += amount
    def balance = _balance

    def withdraw(amount: Int): Boolean = {
        if (amount <= _balance) {
            _balance -= amount
            true
        }
        else
            false
    }
}

class DepositCommand(amount: Int) extends Command[Account] {
    def execute(target: Account): Option[Change] = {
        target.deposit(amount)
        Some(new Change {
            override def undo() = target.withdraw(amount)
        })
    }
}

class WithdrawCommand(amount: Int) extends Command[Account] {
    def execute(target: Account): Option[Change] = {
        val result = target.withdraw(amount)
        if (!result)
            None
        else {
            Some(new Change {
                override def undo() = target.deposit(amount)
            })
        }
    }
  }
}
