package solutions
import scala.math.max
  class Bag[T](_b: T => Int) {
    def b = _b
    def add(x:T): Bag[T] = {
      val newB = (a: T) => if(a == x) b(x)+1 else b(x)
      new Bag(newB)
    }
    def remove(x:T): Bag[T] = {
      val newB = (a: T) => if(a == x) max(b(x)-1,0) else b(x)
      new Bag(newB)
    }
    def count(x:T): Int = {
      b(x)
    }
    def union(that:Bag[T]): Bag[T] = {
      new Bag((x: T) => b(x) + that.b(x))
    }
  }

  class ContraBag[-T](_b: T => Int) {
    def b = _b
    def add(x:T): ContraBag[T] = {
      val newB = (a: T) => if(a == x) b(x)+1 else b(x)
      new ContraBag(newB)
    }
    def remove(x:T): ContraBag[T] = {
      val newB = (a: T) => if(a == x) max(b(x)-1,0) else b(x)
      new ContraBag(newB)
    }
    def count(x:T): Int = {
      b(x)
    }
    def union[A <: T](that:ContraBag[A]): ContraBag[A] = {
      new ContraBag((x: A) => b(x) + that.b(x))
    }
  }
