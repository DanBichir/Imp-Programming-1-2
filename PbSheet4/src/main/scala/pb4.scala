package solutions

import scala.math.max

//undefined when the set is empty
class BitMapSetHead(N: Int) extends BitMapSet(N) {
  def head : Int = {
    for(i <- 0 to n-1){
      if(a(i))  return i
    }
    return n
  }
}

/*
a) First element may not be defined.
The list may not be ordered, so for different permutations of the same list we may achieve different results.
And it is possible to have no first element (empty list).


b)
S = S_0 ^ return x where x ∈ S_0


*/
