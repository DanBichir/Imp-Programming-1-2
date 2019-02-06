package solutions

import org.scalatest.FunSuite

class pb8Test extends FunSuite {
    test("QSort2 small") {
      val x = Array(4,5,1,3,2)
      pb8.a = x
      pb8.QSort2(0,5)
      assert(pb8.a === Array(1,2,3,4,5))
    }
    test("QSort2 double") {
      val x = Array(4,4,3,3,7,7,1,1,6,6)
      pb8.a = x
      pb8.QSort2(0,10)
      assert(pb8.a === Array(1,1,3,3,4,4,6,6,7,7))
    }
    test("QSort2 groups") {
      val x = Array(5,4,5,1,3,2,2,2)
      pb8.a = x
      pb8.QSort2(0,5)
      assert(pb8.a === Array(1,2,2,2,3,4,5,5))
    }
    
}
