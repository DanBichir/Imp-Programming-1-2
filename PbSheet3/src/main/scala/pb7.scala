package solutions

object pb7{  

    /** Partition the segment a[l..r)
    * @return k s.t. a[l..k) < a[k..r) and l <= k < r */
  def partition(l: Int, r: Int) : Int = {
    val x = a(l) // pivot
    // Invariant   a[l+1..i) < x = a(l) <= a[j..r) && l < i <= j <= r
    //          && a[0..l) = a_0[0..l) && a[r..N) = a_0[r..N)
    //          && a[l..r) is a permutation of a_0[l..r)
    var i = l+1; var j = r
    while(i < j){
      if(a(i) < x) i += 1
      else{ val t = a(i); a(i) = a(j-1); a(j-1) = t; j -= 1 }
    }
    // swap pivot into position
    a(l) = a(i-1); a(i-1) = x
    i-1 // position of the pivot
  }
  
  def QSort(l: Int, r: Int) : Unit = {
      if(r-l > 1){ // nothing to do if segment empty or singleton
          val k = partition(l,r)
          QSort(l,k); QSort(k+1,r)
      }
  }
    
  def QSort2(l: Int,r: Int) : Unit = {
      while(r-l > 1){ // nothing to do if segment empty or singleton
          val k = partition(l,r)
          QSort(l,k)
          l = k + 1
      }
  }
    
  def QSortImp(l: Int,r: Int) : Unit = {
      while(r-l > 1){ // nothing to do if segment empty or singleton
          val k = partition(l,r)
          val m = l + (r-l)/2
          if(k<m){
            QSortImp(l,k)
            l = k+1
          }
          else{
            QSortImp(k+1,r)
            r = k
          }
      }
  }
}

/*
b) Worst case scenario is when k always hits l or r-1, resulting in N calls of QSort (for QSort2 k=r-1 will result in N calls of QSort)
*/
