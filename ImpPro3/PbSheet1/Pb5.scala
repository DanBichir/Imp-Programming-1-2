package solutions


object pb5 {
  class Ellipse(private var _a: Int, private var _b: Int) {
    def a = _a
    def a_=(a: Int) = {_a = a}
    def b = _b
    def b_=(b: Int) = {_b = b}
    //No override
    def exchange : Unit = {
      var k = _a
      _a = _b
      _b = k
    }
  }
  class LoggedEllipse(private var _a: Int, private var _b: Int) extends Ellipse(_a,_b){
    private var num = 0
    def getIncreases : Int = n //number of increases
    override def a_=(a: Int) = {
      if(a > _a)  n+=1
      _a = a
    }
    override def b_=(b: Int) = {
      if(b > _b)  n+=1
      _b = b
    }
  }
}

/*
In case we write exchange method this way:

def exchange : Unit = {
  var k = a
  a = b
  b = k

Then we will have to override it (with the previous exchange method).
*/
