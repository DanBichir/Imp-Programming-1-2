package solutions

import scala.math

object pb1{
  trait Shape {
    def area : Double
    def perimeter : Double
    def circle : Boolean
    def square : Boolean
    def setDim(neww : Int, newh : Int) : Unit
  }

  class Rectangle(var w : Int, var h : Int) extends Shape {
    var width = w
    var height = h

    def circle = false

    def square : Boolean = {
      return width == height
    }

    def area : Double = {
      width * height
    }

    def perimeter : Double = {
      return width*2 + height*2
    }

    def setDim (neww : Int, newh : Int) : Unit = {
      assert (neww > 0 && newh > 0)
      width  = neww
      height = newh
    }

    def setSquareDim (len : Int) : Unit = {
      assert (len > 0)
      width  = len
      height = len
    }

  }

  class Ellipse(var M : Int, var m : Int) extends Shape {
    var major = M
    var minor = m

    def circle : Boolean = {
      return major == minor
    }

    def square : Boolean = false

    def area : Double = {
      math.Pi * minor * major
    }

    def perimeter : Double = {
      var a = major.toChar
      var b = minor.toChar
      val pi = math.Pi
      return pi*(3*(a+b)-math.sqrt((3*a+b)*(3*b+a)))

    }
    def setDimension( newM : Int, newm : Int) : Unit = {
      assert( newM > 0 && newm > 0)
      major = newM
      minor = newm
    }

    def setCircleDim (rad : Int) : Unit = {
      assert (rad > 0)
      major  = rad
      minor  = rad
    }

  }
}


/*
All shapes have a common trait named Shape. Then we define two independent classes: Rectangle and Ellipse.
For Square and Circle shapes we add booleans that check in our classes if the current shape is one of them.
*/
