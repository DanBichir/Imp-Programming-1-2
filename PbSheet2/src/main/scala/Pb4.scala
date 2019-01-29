package solutions
object pb4{
  def main(args : Array[String]) = {
    val timeEnd:Double = 1.0
    val numSteps:Int = 999999
    val timeStep:Double = timeEnd/numSteps
    // timeEnd=numSteps*timeStep and numSteps∈ N
    var time = 0.0
    while (time < timeEnd)
    {
        time += timeStep
    }
    println(time)
    // Inv => time == timeEnd
  }
}
//a) numSteps
//b) Maximum error is: timeStep - a small deviation
/**c) 
    while (time < timeEnd -timeStep + k){
        time += timeStep
    }
    where we choose k as a very small positive value (the smaller it is, we will get less inaccurate tests)
    Time will at most be inaccurate by k - deviation, so it becomes more accurate as k decreases**/
    
