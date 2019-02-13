package solutions

import org.scalatest.FunSuite

class pb4Test extends FunSuite {
  test("Test1"){
    val set = new BitMapSetHead(100)
    set.add(3)
    set.add(4)
    set.add(5)
    assert(set.head === 4)
  }
  test("Test2"){
    val set = new BitMapSetHead(100)
    assert(set.head === 100)
  }
}
