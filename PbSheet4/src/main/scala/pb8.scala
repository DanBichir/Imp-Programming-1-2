package solutions

object pb8{
  def sort(MAX: Int, a : Array[Int]) : Array[Int] = {
    val bag = new BagImp(MAX)
    val i = 0
    val len = a.length
    while(i < len){
      bag.add(a(i))
      i += 1
    }
    val ord = new Array[Int](a.length)
    var pos = 0
    val j = 0
    while(i < len){
      while(bag.count(pos) == 0) pos += 1
      while(j < bag.count(pos)){
        ord(i+j) = pos
      }
      i += bag.count(pos)
      pos +=1
    }
    ord
  }
}
