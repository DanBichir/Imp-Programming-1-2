package solutions

object pb2{
  def sqrt(y:Int) : Int = {
    assert(y>=0)
    var a = 0; var b = y+1
    while(a+1<b){
      val m = a + (b-a)/2
      if(m*m<=y) a = m 
      else       b = m
    }
    return a
  }
  def search(a: Int) : Int = {
  var i = 0; var j = a
  var x = (j-i)/3
  var m = i+x
  var n = i+x*2
  while(j>i){
    if (m*m==a) return m
    if(m*m>a)   j = m
    else if(n*n<a) i = n
    else if (n*n ==a) return n
    else{
      i = m+1
      j = n
    }
    x = (j-i)/3
    m = i+x
    n = i+x*2
  }
  i
}
  def maxsearch(a: Int) : Int = {
  var i = 0; var j = 46000
  var x = (j-i)/3
  var m = i+x
  var n = i+x*2
  while(j>i){
    if (m*m==a) return m
    if(m*m>a)   j = m
    else if(n*n<a) i = n
    else if (n*n ==a) return n
    else{
      i = m+1
      j = n
    }
    x = (j-i)/3
    m = i+x
    n = i+x*2
  }
  i
}
}
// b) It will stop when it reaches one element, which will be the final result
