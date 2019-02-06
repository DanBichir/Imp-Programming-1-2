package solutions

object pb6{
    var a = (8,10,3,4,13)

def partition2(l: Int, r: Int) : Int = {
    val x = a(l) // pivot
    // Invariant a[l+1..i) < x = a(l) <= a[j..r) && l < i <= j <= r
    // && a(j) < x
    // && a[0..l) = a_0[0..l) && a[r..N) = a_0[r..N)
    // && a[l..r) is a permutation of a_0[l..r)
    var i = l+1; var j = r
    
    while(a(j-1) >= x && i < j){
        j -= 1
    }
    while(i < j){
      if(a(i) < x) i += 1
      else{
        val t = a(i); a(i) = a(j-1); a(j-1) = t; j -= 1
      }
    }
    // swap pivot into position
    a(l) = a(i-1); a(i-1) = x
    i-1 // position of the pivot
  }
}
// (8,10,3,4,13) 13 will be changing position twice
