package solutions
object pb4{

  trait Command[T] {
      def execute(target: T): Option[Change]
  }
  trait Change {
      def undo(): Unit
  }

  class AndThenCommand[T](first: Command[T], second: Command[T]) extends Command[T] {
    def execute(target: T): Option[Change] = {
        val res = first.execute(target)
        res match {
            case None    => None
            case Some(r) => {
                val res2 = second.execute(target)
                res2 match {
                    case None => {
                        r.undo
                        None
                    }
                    case Some(r2) => {
                        Some(new Change {
                            def undo = {
                                r2.undo
                                r.undo
                            }
                        })
                    }
                }
            }
        }
    }
  }

  def makeTransaction[T](commands: List[Command[T]]): Command[T] = new Command[T] {
    def execute(target: T): Option[Change] = {
        commands match {
            case Nil => Some(new Change {def undo = {}})
            case x :: Nil  => x.execute(target)
            case x :: tail => new AndThenCommand[T](x, makeTransaction[T](tail)).execute(target)
        }
    }
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

val ac1 = new BasicAccount(50)
val d10 = new DepositCommand(10)
val w5 = new WithdrawCommand(5)

val t = makeTransaction(List(d10,d10,w5,d10,w5))
val c1 = t.execute(ac1)
println("Balance is: " + ac1.balance) // 70
c1.get.undo()
println("Balance is: " + ac1.balance) // 50

}
