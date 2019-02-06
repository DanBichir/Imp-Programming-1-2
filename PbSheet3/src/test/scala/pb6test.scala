package solutions

import org.scalatest.FunSuite

class pb6Test extends FunSuite {
    test("Test") {
      val new = Array(8,10,3,4,13)
      pb6.a = new
      assert(pb6.partition2(0,5) === 2)
    }
}
