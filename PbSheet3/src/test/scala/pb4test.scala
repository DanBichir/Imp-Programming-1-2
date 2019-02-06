package solutions

import org.scalatest.FunSuite

class pb4Test extends FunSuite {
    test("Test1") {
      val x = Array(5,1,2,3,4)
      assert(pb4.sort(x) === Array(1,2,3,4,5))
    }
    test("Test2") {
      val y = Array(1,2,5,3,4)
      assert(pb4.sort(y) === Array(1,2,3,4,5))
    }
}
