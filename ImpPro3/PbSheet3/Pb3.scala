package solutions

import scala.util.control.Breaks._

object pb3{
  trait PartialOrder[T] {
    def <=(that: T): Boolean  // checks this <= that. Partial order on T.
    def lub(that: T): T       // returns the least upper bound of this and that.
  }
  class MySet[T](elements:Set[T],elementsList:List[T]) extends PartialOrder[MySet[T]] with Set[T] {
    private var items : List[T] = elementsList

    def this(elements:Set[T]){
      this(elements,elements.iterator.toList)
    }

    def this(elements:List[T]){
      this(null,elements)
    }

    def <=(that: MySet[T]):Boolean = {
      var res = this.iterator.toList
      var out = res.map(that.contains)
      out.foldLeft(true)(_ & _)
    }

    def ==(that: MySet[T]):Boolean = {
      this<=that && that <= this
    }

    //Least upper bound union of 2 sets
    def lub(that: MySet[T]) : MySet[T] = {
      var u = that
      var it = this.iterator
      while (it.hasNext){
        u = u + it.next
      }
      u
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
    override def empty() : MySet[T] = {
      new MySet(List[T]())
    }
  }

  class UpSet[T <: PartialOrder[T]](elements:Set[T]) extends PartialOrder[UpSet[T]]{
    var lowerBounds = makeUpperClosed(elements)
    private def makeUpperClosed(_minimuns:Set[T]):Set[T] = {
      var currentUpperClosed : Set[T] = new MySet(List())
      for (curr <- _minimuns.iterator){
        currentUpperClosed = addToUpperClosed(currentUpperClosed,curr)
      }
      currentUpperClosed
    }


    private def addToUpperClosed(_minimuns: Set[T],x:T) = {

      var minimuns = _minimuns + x
      /*Loops throughs all sets of pairs until no pair contains any element which is greater than the other*/
      while(true){
        var iteratorChanged = false
        for(start <- minimuns.iterator){
          for(end <- minimuns.iterator){
            if(start!=end){
              if(start<=end || end<=start){
                minimuns = minimuns - start
                minimuns = minimuns - end
                minimuns = minimuns + start.lub(end)
                iteratorChanged = true
              }
            }
            if(iteratorChanged)break
          }
          if(iteratorChanged)break
        }
        if(!iteratorChanged)break
      }
      minimuns
    }

    def contains(x: T): Boolean = {
      var it = elements.iterator
      while(it.hasNext){
        if(! (it.next<=x)){
          return false
        }
      }
      true
    }
    def intersection(that: UpSet[T]): UpSet[T] = {
      new UpSet(makeUpperClosed(this.lowerBounds union that.lowerBounds))
    }
    def <=(that: UpSet[T]): Boolean = {
      this.lub(that).lowerBounds == this.lowerBounds
    } // checks this <= that. Partial order on T.
    def lub(that: UpSet[T]): UpSet[T]  = {
      var minimuns = lowerBounds union that.lowerBounds
      while(true){
        var iteratorChanged = false
        for(start <- minimuns.iterator){
          for(end <- minimuns.iterator){
            if(start!=end){
              if(start<=end){
                minimuns = minimuns - end
                iteratorChanged = true
              }
              if(end<=start){
                minimuns = minimuns - start
                iteratorChanged = true
              }
            }
            if(iteratorChanged)break
          }
          if(iteratorChanged)break
        }
        if(!iteratorChanged)break
      }
      new UpSet(minimuns)
      /*Removes the greater elements from the joint set of minimums*/
    }
  }
}
