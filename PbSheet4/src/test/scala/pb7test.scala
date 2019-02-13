package solutions

import org.scalatest.FunSuite

class pb7Test extends FunSuite {
  test("Test1"){
    val bag = new BagImp(100)
    bag.add(20)
    assert(bag.count(20) === 1)
    bag.add(20)
    assert(bag.count(20) === 2)
    bag.add(20)
    assert(bag.count(20) === 3)
  }
  test("Test2"){
    val bag = new BagImp(100)
    assert(bag.count(19) === 0)
  }
}
