package solutions

object pb1{

  class FilterIterator[T] (test: T => Boolean, it: Iterator[T]) extends Iterator[T]{
      var iter: Iterator[T] = it
      def hasNext: Boolean = {
        iter = iter.dropWhile(x => !(test(x)))
        iter.hasNext
      }
      def next() = {
        iter = iter.dropWhile(x => !(test(x)))
        iter.next
      }
    }
}
