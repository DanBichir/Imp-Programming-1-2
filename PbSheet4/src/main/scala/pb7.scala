package solutions



/** state: bag : Int -> Int
  * init: bag = {} 
  */
trait Bag {


  /*Add elem to the bag if it is within bounds.
  post: bag = (bag ⊕ {elem -> bag (elem) +1}) */
  def add(elem: Int)
  
  
  /** Occurences of elem in the bag
  * post: bag = bag_0 ^ return bag(elem)  */
  def count(elem: Int): Int
  
}

class BagImp(MAXc : Int) extends Bag {
  val MAX : Int = MAXc
  val c = new Array[Int](MAX)

  //Abs: bag = { (i -> c(i)) | i ∈ [0,MAX) }
  def add(elem: Int) = {
    if(elem < MAX && elem >= 0){
      c(elem) += 1
    }
  }

  def count(elem: Int) : Int = {
    if(elem < MAX && elem >= 0)   
        return c(elem)
    return 0
  }
}
