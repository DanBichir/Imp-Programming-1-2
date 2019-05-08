
package solutions

object pb3{
  class Rectangle(var width: Int, var height: Int)
    class Slab(private val _dimension: Rectangle) {
      private val _area = _dimension.width * _dimension.height
      def dimension = _dimension

      def viewArea : Int = _area
  }

    class Slabv2(private val _dimension: Rectangle) {
      private def _area = _dimension.width * _dimension.height
      def dimension = _dimension

      def viewArea : Int = _area
    }
}
// The initial area does not update at every change of its width or height
