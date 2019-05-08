package solutions

object pb2{
  class Rectangle(var width: Int, var height: Int) {
    var area = width * height
  }
  class Rectanglev2(private var w: Int, private var h: Int) {
    def area: Int = width * height

    def width  = w
    def height = h

    def set (width: Int , height: Int) = {
      assert(width > 0 &&  height > 0)
      w = width
      h = height
    }
  }
}

/*
The initial area will keep the same value, even when we change values of width and or height.

We should also check if the input values are positive.
*/
