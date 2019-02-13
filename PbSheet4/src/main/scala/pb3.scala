package solutions

/** state: S : P Int
* init: S = {} */

trait IntSet{


/** Add elem to the set if it is within bounds.
* post: S = S ∪ {elem | elem < N, elem >= 0} */
  def add(elem: Int)

/** Checks for elem in set
* post: S = S ∧ returns elem ∈ S */
  def isIn(elem: Int): Boolean

/** Remove elem from the set.
* post: S = S − {elem} */
  def remove(elem: Int)

/** The size of the set.
* post: S = S ∧ returns |S| */
  def size : Int
}

class BitMapSet(N: Int) extends IntSet {
  val n: Int = N
  val a : Array[Boolean] = Array.fill(n){false}
  var counter : Int = 0

  // Abs: S = {x | x ∈ Z, 0 <= x < n | a(x) == true}
  // DTI: 0 <= counter <= N ^ counter = |S|
  def add(elem: Int) : Unit = {
    if(elem < n && elem >= 0){
      if(a(elem)!=0)  counter += 1
      a(elem) = true
    }
  }

  def isIn(elem : Int) : Boolean = {
    if(elem < n && elem >= 0) 
        return a(elem)
    return false
  }

  def remove(elem: Int) : Unit = {
    if(elem < n && elem >= 0){
      if(a(elem))   counter -= 1
      a(elem) = false
    }
  }

  def size : Int = {
    counter
  }
}
