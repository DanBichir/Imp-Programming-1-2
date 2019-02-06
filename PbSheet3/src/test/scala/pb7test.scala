
package solutions

import org.scalatest.FunSuite

class pb7Test extends FunSuite {
    test("QSort") {
      val x = Array(4,5,1,3,2)
      pb7.a = x
      pb7.QSort(0,5)
      assert(pb7.a === Array(1,2,3,4,5))
    }
    test("QSort2") {
      val x = Array(10,3,7,1,6)
      pb7.a = x
      pb7.QSort2(0,5)
      assert(pb7.a === Array(1,3,6,7,10))
    }
    test("QSortImp") {
      val x = Array(13,11,7,5,3)
      pb7.a = x
      pb7.QSortImp(0,5)
      assert(pb7.a === Array(3,5,7,11,13))
    }
}
