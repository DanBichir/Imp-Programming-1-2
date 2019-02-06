package solutions


object pb3{
  def tooBig(y: BigInt, x: BigInt): Boolean = {
      y > x
  }
  //a) 10 calls
  def search1(x: BigInt): BigInt = {
    var i=0
    var j=1000
    while(i<j){
      if(tooBig(i+(j-i)/2,x)) i = i+(j-i)/2 
      else j = i+(j-i)/2
      //halves the interval with every step (like binary search)
    }
    i
  }
  // b)
  def search2(x: BigInt): BigInt = {
    var i = 1
    while(tooBig(i,x)==0)  i=i*2
    var j = i
    i = i/2
    // searches in interval [i,j]
    while(i<j){
      if(tooBig(i+(j-i)/2,x)) i = i+(j-i)/2
      else j = i+(j-i)/2
    }
    i
  }
  //c) We change i=i*2 to i=i*(2^(1/eps))
 }
