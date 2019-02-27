package solutions

class IntQueue extends Queue[Int]{
    var head : Node = new Node(Int.MinValue,null)
    var tail : Node = head


    // post: s = s ^ returns s == []
    def isEmpty : Boolean = {
        head == tail
    }
    /* Add x at the start of the queue. */
    // post : s = [x] ++ s
    def enqueue(x:Int) = {
        var Node1 = new Node(x,null)
        tail.next = Node1
        tail = tail.next
    }

    /**Select and delete an element at the end of the queue. */
    // pre: |s| > 0
    // post: s = init s ^ returns last s
    def dequeue : Int = {
        val rest = head.next.datum
        head.next = head.next.next
        rest
    }

}
/*
state s: seq Int
s = l(head.next)
l(tail) = []
l(a) = a.datum:L(a.next)

Datatype Invariant: l(head.next) is finite and the names in l(head.next) are distinct
*/
