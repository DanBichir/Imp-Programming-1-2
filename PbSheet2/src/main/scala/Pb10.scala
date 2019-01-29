package solutions
object pb10{

def eval(a: Array[Double], x: Double) : Double =
 {
   val n=a.size
   var sum:Double=0
   while(n>0){
      //n>=0
      n=n-1
    	sum=sum*x+a(n)
     }
   sum 
 }
}
