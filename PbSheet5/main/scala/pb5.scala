package solutions

/* A queue of data of type A.
* state: q : seq A
* init: q = [] */

trait Queue[A]{

  /* Add x to the back of the queue
  * post: q = q ++ [x] */
  def enqueue(x: A)
  
  /* Remove and return the first element.
  * pre: q != []
  * post: q = tail q ∧ returns head q
  * or post: returns x such that q = [x] ++ q */
  def dequeue: A
  
  /* Check if empty
  * post: q = q ∧ returns q = [] */
  def isEmpty: Boolean
}


/*
state: s : seq Int
init: s = []
s = l(left,size)
l(left,0) = []
l(left,size) = s(left):l((left+1)%MAX,size-1)
DTI: size <= MAX && 0 <= left < MAX
*/



class ArrayQueue extends Queue[Int]{
    val MAX = 100
    var data = new Array[Int](100)
    var size = 0
    var left = 0
    
    def isEmpty() : Boolean =  size == 0

    def enqueue(x : Int){
      data((size+left)%MAX) = x
      size += 1
    }
    
    def dequeue() : Int = {
      val rest = data(left)
      size-=1
      left=(left+1)%MAX
      return rest
    }

    def isFull : Boolean = size == MAX
}
