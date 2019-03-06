package solutions

// A hash table, where we store how many times a word has been recorded

// Companion object
object HashBag{
  // Nodes linked lists
  private class Node(val word: String, var count: Int)
}

/*
Datatype Invariant:
  Every node in the table has node.count > 0
  The occurences of partcular hash are in a range with no null values
*/
class HashBag{
  private def hash(word: String) : Int = {
    def f(e: Int, c: Char) = (e*41 + c.toInt) % N
    word.foldLeft(1)(f)
  }

  private var N = 100
  private var size_ = 0 // number of different words memorised
  private val table = new Array[HashBag.Node](N) // the hash table


  private def find(word: String) : Int = {
    var pos: Int = hash(word)
    var i = 0
    while(table(pos) != null && table(pos).word != word && i < N){
      pos = (pos + 1) % N
      i += 1
    }
    if(table(pos) == null || table(pos).word != word)return -1
    pos
  }

  private def empty(word: String) : Int = {
    var pos: Int = hash(word)
    var i = 0
    while(table(pos) != null && i < N){
      pos = (pos + 1) % N
      i += 1
    }
    pos
  }

  def size = size_

  // Add new word record
  def add(word: String) = {
    val n = find(word)
    if(n != -1) table(n).count += 1
    else{
      table(empty(word)) = new HashBag.Node(word, 1)
      size_ += 1
    }
  }

  // Remove word record
  def delete(word: String) : Boolean = {
    val n = find(word)
    if(n == -1) return false
    else{
      table(n).count -= 1
      if(table(n).count == 0){
          table(n) = null
          var i = 0;
          var prenull = n
          //We avoid swapping elements back before their own hash position when it is possible
          while(i < N && table((prenull+1)%N) != null && hash(table((prenull+1)%N).word) != (prenull+1)%N) {
            table(prenull) = table((prenull+1)%N)
            i+=1
            prenull = (prenull+1)%N
          }
          size_ -= 1
      }
      return true
    }
  }

  // The stored number of records of a word
  def count(word: String) : Int = {
    val n = find(word)
    if(n != -1) table(n).count else 0
  }
}
