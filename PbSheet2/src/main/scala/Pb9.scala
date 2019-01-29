package solutions
import scala.math.max

object pb9{

  def log3(x : Double) : Int = {
    var pow = 0
    var nr = 1
    while(pow*3 <= x){
      nr+=1
      pow *= 3
    }
    return nr
  }
 }
