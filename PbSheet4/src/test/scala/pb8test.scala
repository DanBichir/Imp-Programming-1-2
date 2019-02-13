package solutions

import org.scalatest.FunSuite
import scala.util.Random

class pb8Test extends FunSuite {
  test("Random Array Sort") {
    val MAX = Random.nextInt(100)
    val a = Array.fill(100){Random.nextInt(MAX)}
    val s = pb8.sort(MAX,a)
    assert(s === a.sorted)
  }
}
