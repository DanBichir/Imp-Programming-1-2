package solutions

class Node(var datum: Int, var next: Node){
    override def toString : String = {
        var pos = new Node(datum,next)
        var l : String = ""
        while(pos != null){
            l+= pos.datum.toString + " -> "
            pos = pos.next
        }
        l = l.dropRight(4)
        l + "."
    }
}


object pb1{
  def createList(){
    var myList : Node = null
    i=1
    while(i<=12){
      myList = new Node(i,myList)
      i+=1
    }
    println("The new list is " + myList)
  }

  def reverseList(){
    var myList : Node = null
    i=0
    while(i<=12){
      myList = new Node(i,myList)
      i+=1
    }
    println("Initial list is " + myList)
    var reversed : Node = null
    var k : Node = null

    //Invariant : reversed = reverse takes i 
    while(myList != null){
      k = myList.next
      myList.next = reversed
      reversed = myList
      myList = k
    }

    println("Reversed list is " + revList)

  }
}
