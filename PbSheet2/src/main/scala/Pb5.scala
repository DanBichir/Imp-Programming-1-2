package solutions

object pb5{
  /** Does pat appear as a substring of line? */
  def search(pat: Array[Char], line: Array[Char]) : Boolean = {
  val K = pat.size; val N = line.size
  // Invariant: I: found = (line[i..i+K) = pat[0..K) for
  // some i in [0..j)) and 0 <= j <= N-K
  var j = 0; var found = false
  while(j <= N-K && !found){
    // set found if line[j..j+K) = pat[0..K)
    // Invariant: line[j..j+k) = pat[0..k)
    var k = 0
    while(k<K && line(j+k)==pat(k)){
      k = k+1
    }
      found = (k==K)
      j = j+1
    }
    // I && (j=N-K+1 || found)
    // found = ( line[i..i+K) = pat[0..K) for some i in [0..N-K+1) )
    found
  }
  def search1(pat: Array[Char], line: Array[Char]) : Boolean = {
  val K = pat.size; val N = line.size
  // Invariant: I: found = (line[i..i+K) = pat[0..K) for
  // some i in [0..j)) and 0 <= j <= N-K
  var j = 0; var found = true
  while(j <= N-K && !found){
    // set found if line[j..j+K) = pat[0..K)
    // Invariant: line[j..j+k) = pat[0..k)
    var k = 0
    while(k<K && line(j+k)==pat(k)) k = k+1
      found = (k==K)
      j = j+1
    }
    // I && (j=N-K+1 || found)
    // found = ( line[i..i+K) = pat[0..K) for some i in [0..N-K+1) )
    found
  }
  def search2(pat: Array[Char], line: Array[Char]) : Boolean = {
  val K = pat.size; val N = line.size
  // Invariant: I: found = (line[i..i+K) = pat[0..K) for
  // some i in [0..j)) and 0 <= j <= N-K
  var j = 0; var found = false
  while(j < N-K && !found){
    // set found if line[j..j+K) = pat[0..K)
    // Invariant: line[j..j+k) = pat[0..k)
    var k = 0
    while(k<K && line(j+k)==pat(k)) k = k+1
      found = (k==K)
      j = j+1
    }
    // I && (j=N-K+1 || found)
    // found = ( line[i..i+K) = pat[0..K) for some i in [0..N-K+1) )
    found
  }
  def search3(pat: Array[Char], line: Array[Char]) : Boolean = {
  val K = pat.size; val N = line.size
  // Invariant: I: found = (line[i..i+K) = pat[0..K) for
  // some i in [0..j)) and 0 <= j <= N-K
  var j = 0; var found = false
  while(j <= N-K+1 && !found){
    // set found if line[j..j+K) = pat[0..K)
    // Invariant: line[j..j+k) = pat[0..k)
    var k = 0
    while(k<K && line(j+k)==pat(k)) k = k+1
      found = (k==K)
      j = j+1
    }
    // I && (j=N-K+1 || found)
    // found = ( line[i..i+K) = pat[0..K) for some i in [0..N-K+1) )
    found
  }
  def search4(pat: Array[Char], line: Array[Char]) : Boolean = {
  val K = pat.size; val N = line.size
  // Invariant: I: found = (line[i..i+K) = pat[0..K) for
  // some i in [0..j)) and 0 <= j <= N-K
  var j = 0; var found = false
  while(j <= N-K && !found){
    // set found if line[j..j+K) = pat[0..K)
    // Invariant: line[j..j+k) = pat[0..k)
    var k = 1
    while(k<K && line(j+k)==pat(k)) k = k+1
      found = (k==K)
      j = j+1
    }
    // I && (j=N-K+1 || found)
    // found = ( line[i..i+K) = pat[0..K) for some i in [0..N-K+1) )
    found
  }
  def search5(pat: Array[Char], line: Array[Char]) : Boolean = {
  val K = pat.size; val N = line.size
  // Invariant: I: found = (line[i..i+K) = pat[0..K) for
  // some i in [0..j)) and 0 <= j <= N-K
  var j = 0; var found = false
  while(j <= N-K && !found){
    // set found if line[j..j+K) = pat[0..K)
    // Invariant: line[j..j+k) = pat[0..k)
    var k = 0
    while(k<=K && line(j+k)==pat(k)) k = k+1
      found = (k==K)
      j = j+1
    }
    // I && (j=N-K+1 || found)
    // found = ( line[i..i+K) = pat[0..K) for some i in [0..N-K+1) )
    found
  }
  def search6(pat: Array[Char], line: Array[Char]) : Boolean = {
  val K = pat.size; val N = line.size
  // Invariant: I: found = (line[i..i+K) = pat[0..K) for
  // some i in [0..j)) and 0 <= j <= N-K
  var j = 0; var found = false
  while(j <= N-K && !found){
      // set found if line[j..j+K) = pat[0..K)
      // Invariant: line[j..j+k) = pat[0..k)
      var k = 0
      while(k<K && line(j+k)==pat(k)) k = k+1
      found = (k>=K)
      j = j+1
    }
    // I && (j=N-K+1 || found)
    // found = ( line[i..i+K) = pat[0..K) for some i in [0..N-K+1) )
    found
  }
}
// a) Shows true all the time
// b) The pattern is not found if it is at the end of the array
// c) The function goes out of bounds and will generate an error
// d) First character will be matched with everything
// e) When a pattern occurs, an out of bound error will happen
// f) There is no bug here
