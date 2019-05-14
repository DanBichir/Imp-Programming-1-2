 package solutions

object pb5{

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


  class WhileCommand[T](test:T => Boolean, cmd:Command[T]) extends Command[T] {
    def execute(target: T): Option[Change] = {
      if (!test(target))
          Some(new Change {def undo = {}})
      else {
          val res = cmd.execute(target)
          res match {
              case None    => None
              case Some(r) => {
                  val res2 = execute(target)
                  res2 match {
                      case None => {
                          r.undo
                          None
                      }
                      case Some(r2) => Some (new Change {
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

  def threshold(limit: Int, target: PriorityQueue): Boolean = {
    if (target.isEmpty)
      return false

    val m = target.delMin
    target.insert(m)
    return m < limit
  }
}
