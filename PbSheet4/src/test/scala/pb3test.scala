package solutions

import org.scalatest.FunSuite

class pb3Test extends FunSuite {
  test("Test1"){
    val set = new BitMapSet(100)
    set.add(20)
    assert(set.isIn(20) == true)
  }
  test("Test2"){
    val set = new BitMapSet(100)
    set.add(15)
    set.remove(15)
    assert(set.isIn(15) == false)
  }
  test("Test3"){
    val set = new BitMapSet(100)
    set.remove(15)
    assert(set.isIn(15) == false)
  }
  test("Test4"){
    val set = new BitMapSet(100)
    set.add(19)
    set.add(19)
    set.add(20)
    set.add(19)
    
    assert(set.size == 2)
  }
}
