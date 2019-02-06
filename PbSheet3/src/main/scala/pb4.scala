package solutions

object pb4{
def sort(A : Array[Int]) : Array[Int] = {
  for(j<- 0 to A.length – 1){ 
     key = A(j)
     i = j
      while (i > 0 && A(i – 1) > key){ 
         A(i) = A(i – 1)
         i = i − 1
      }
      A(i) = key
    }
    A
  }
}

// The number of operations is of order n^2
