package solutions

object pb3{


  trait Command[T] {
      def execute(target: T): Option[Change]
  }
  
  trait Change {
      def undo(): Unit
  }

  trait PriorityQueue {
    def isEmpty: Boolean // Determine if queue is empty
    def insert(e:Int) // Place the element e in the queue
    def remove(e:Int) // Remove (one copy of) element e (if present)
    // ...(this operation is needed to undo insert)
    def delMin(): Int // Remove and return the smallest element
 }
class InsertCommand(x: Int) extends Command[PriorityQueue] {
    def execute(target: PriorityQueue): Option[Change] = {
        target.insert(x)
        Some(new Change {
            def undo = target.remove(x)
        })
    }
  }

  class DelMinCommand extends Command[PriorityQueue] {
    def execute(target: PriorityQueue): Option[Change] = {
        if (!target.isEmpty) {
            val aux = target.delMin
            Some(new Change {
                def undo = target.insert(aux)
            })
        }
        else
            None
    }
  }

}
