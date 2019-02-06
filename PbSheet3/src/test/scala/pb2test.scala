package solutions

import org.scalatest.FunSuite

class pb2Test extends FunSuite {
    test("Easy test") {
      assert(pb2.search(9) === 3)
    }
    test("Max test") {
      for(i <- 1 to 46000){
        assert(pb2.search(i) === pb2.sqrt(i))
      }
    }
    test("Check new test") {
      for(i <- 1 to 46000){
        assert(pb2.maxsearch(i) === pb2.sqrt(i))
      }
    }
    
}
