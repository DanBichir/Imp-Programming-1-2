package solutions

import org.scalatest.FunSuite



//Tests for pb 1

class pb1Test extends FunSuite {
    test("Add test") {
      val set = new scala.collection.mutable.HashSet[Int]
      set.add(2);
      assert(set.contains(2)===true)
    }
    test("Remove test") {
      val set = new scala.collection.mutable.HashSet[Int]
      set.add(5); set.remove(5)
      assert(set.contains(5)===false)
    }
    test("Contains test") {
      val set = new scala.collection.mutable.HashSet[Int]
      set.add(2); set.add(3); set.add(1)
      assert(set.contains(3)===true)
    }
    test("Size test") {
      val set = new scala.collection.mutable.HashSet[Int]
      set.add(1); set.add(2); set.add(3); set.add(4); set.add(5); set.add(6); set.add(7)
      assert(set.size===6)
    }
    test("isEmpty test") {
      val set = new scala.collection.mutable.HashSet[Int]
      set.add(2)
      set.remove(2)
      assert(set.isEmpty === true)
    }
     test("Remove on missing element") {
      val set = new scala.collection.mutable.HashSet[Int]
      set.remove(5); set.add(1); set.add(2)
      assert(set.size=== 2)
    }
    test("Adding a copy") {
      val set = new scala.collection.mutable.HashSet[Int]
      set.add(9); set.add(9); set.remove(9)
      assert(set.contains(1)===false)
    }
}
