package solutions

object pb8{

/*
  a)	O(n^2)
  b)	The depth of the stack increases by the number of identical values a pivot has
  c)	If there are duplicates, changing < to <= will result in an infinite loop
  e)  The new version will avoid the cases where elements are removed one-by-one by grouping duplicates altogether*/
    /** Partition the segment a[l..r)
  * @return k s.t. a[l..k) < a[k..r) and l <= k < r */
  def partition2(l: Int, r: Int) : (Int,Int) = {
    val x = a(l) // pivot
    // Invariant a[l+1..i) < x = a(l) < a[j..r) && l < i <= j <= r
    // && a[0..l) = a_0[0..l) && a[r..N) = a_0[r..N)
    // && a[l..r) is a permutation of a_0[l..r)
    var i = l+1; var j = r;var k = i
    
    while(i < j){
      if(a(i) == x) i += 1
      
      else if(a(i) > x){
        val t = a(i)
        a(i) = a(j-1)
        a(j-1) = t
        j -= 1 
      }
      
      else{  
        val t = a(i); a(i) = a(k); a(k) = t;
        i += 1;k += 1
      }
      
    }
    // swap pivot into position
    a(l) = a(k-1); a(k-1) = x
    (k-1,j) // position of the pivot
    
 }
def QSort2(l: Int, r: Int) : Unit = {
    if(r-l > 1){ // nothing to do if segment empty or singleton
      val (i,j)  = partition2(l,r)
      QSort2(l,i); QSort2(j,r)
    }
  }
 }
