package solutions

object pb7{
def exists(p : Int => Boolean, N : Int) =
 {
   var j=0
   var c=0;
   while(j<N)                       \\ the invariant is j<N
   {
     if (p(j)==true) println(j)  
     j=j+1;
     c=1;
   }
   if (c==0) println("Does not exist");
 }
 }
