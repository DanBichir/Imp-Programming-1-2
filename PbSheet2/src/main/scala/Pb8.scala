
object pb8{
def reciprocal (p:Int,q:Int):Int  = {
    val i:Int = q/p
    if (q%p==0) return i
    return i+1
   }
def arrayGen(size : Int ,p : Int, q : Int) : Array[Int] = {
    var d = new Array[Int](size)
    var i = 0
    var m = 0
    while(p > 0){
        m = reciprocal(p,q)
        d(i)=m
        p=p*m-q
        q=q*m
        i+=1
     }
    return d.slice(0,i)
   }
}
/** If the value of p > q then reciprocal will always return 1 and p=p-1
 If p<q we know that 1/m < p/q < 1/(m-1) so (m-1)p < q => m*p - p < q => p > p * m - q => p is strictly decreasing.
 Since p is int, it will decrease by at least 1 every loop and reach 0, the loop terminating.
 Array d is increasing because m is increasing (1/m decreasing) because 1/m < p/q and p/q is decreasing.
 If we have two consecutive identical values of m then 1/m+1 > p/q > 2/m  which is a contradiction.
 In conclusion, d is strictly increasing
 
 **/

