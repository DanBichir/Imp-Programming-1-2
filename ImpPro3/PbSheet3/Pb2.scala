package solutions


object pb2 {
  class MySet[T](elements:Set[T],elementsList:List[T]) extends Set[T] {

    private var items : List[T] = elementsList

    def this(elements:Set[T]){
      this(elements,elements.iterator.toList)
    }

    def this(elements:List[T]){
      this(null,elements)
    }

    override def empty() : MySet[T] = {
      new MySet(List[T]())
    }

    def contains(key: T): Boolean = {
      items.contains(key)
    }

    def iterator: Iterator[T] =  {
      items.iterator
    }

    def +(elem: T): MySet[T] = {
      if(!contains(elem)){
        return new MySet(items:+elem)
      }
      new MySet(items)
    }

    def -(elem: T): MySet[T] = {
      if(contains(elem)){
        return new MySet(items diff List(elem))
      }
      new MySet(items)
    }
  }
}
