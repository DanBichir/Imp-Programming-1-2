package solutions


class DoubleEndedQueue{
    class Node(var datum: Int, var prev: Node, var next: Node)
    var head : Node = new Node(Int.MinValue,null,null)

    var tail : Node = new Node(Int.MinValue,head,null)

    head.next = tail

    // post: s = s ^ returns s == []
    def isEmpty : Boolean = {
        head.next.next == null
    }
  
    /** Add x to the start of the queue. */
    // post : s = [x] ++ s
    def addLeft(x:Int) = {
        var Node1 = new Node(x,head,head.next)
        Node1.next.prev = Node1
        head.next = Node1
    }
  
    /** Select and remove element from the start of the queue. */
    // pre: |s| > 0
    // post: s = tail s ^ returns head s
    def getLeft : Int = {
        val rest = head.next.datum
        head.next = head.next.next
        head.next.prev = head
        return rest
    }
  
    /** Add element at the end of the queue. */
    // post:  s = s ++ [x]
    def addRight(x: Int) = {
        var Node1 = new Node(x,tail.prev, tail)
        tail.prev.next  = Node1
        tail.prev = Node1
    }
  
    /** Select and remove element from the end of the queue. */
    // pre: |s| > 0
    // post: s = init s ^ returns last s
    def getRight : Int = {
        val rest = tail.prev.datum
        tail.prev = tail.prev.prev
        tail.prev.next = tail
        return rest
    }

}

/*
state s: seq Int
s = l(head.next)
l(tail) = []
l(a) = a.datum:l(a.next)
DTI: l(head.next) is finite and the names in l(head.next) are distinct
*/
