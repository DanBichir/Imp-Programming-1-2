package solutions


object problem6{
def repeat(keyc:Array[Char]) : Int =
  {
    val k=keyc.size
    var i=0
    var ctest=1
   for (j<-1 until k)
    { ctest=1
     for (i<-0 until k-j)
      if (keyc(i) != keyc(i+j)) ctest=0
     if (ctest==1) return j
    } 
    return 0
  } 
}
