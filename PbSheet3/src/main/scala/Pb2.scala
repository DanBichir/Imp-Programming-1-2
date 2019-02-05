package solutions

object pb2{
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
}
// b) It will stop when it reaches one element, which will be the final result
