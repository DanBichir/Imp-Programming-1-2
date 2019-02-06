package solutions

import org.scalatest.FunSuite

class pb3Test extends FunSuite {
    test("Small Test") {
      assert(pb3.search1(372) === 372)
    }
    test("Big Test") {
      assert(pb3.search2(8675645) === 8675645)
    }
    test("Bigger Test") {
      assert(pb3.search2(118584179) === 118584179)
    }
  
}
