package solutions

//Pb 1
object pbs1{
	def square(n: Int) : Int = {
  		n*n
	}

	def remainder3(n: Int) : Int = {
  		n-(n/3)*3
	}

	def maxsquare(n: Int) : Int ={
  	var i=0
  	while(i*i<=n){
		i+=1;
  	}
  	(i-1)*(i-1)
	}

//Pb 3

	object Milk{

  	def findMax(a : Array[Int]) : Int = {
    	val n = a.size
    	var max = 0; var i = 0
    	while(i < n){
      		//Invariant I: max=max(a[0..i)) && 0<=i<=n
      		//Variant n-i
      		if(a(i)>max) max=a(i)
      		i += 1
    		}
    		max
  	}
  }

//Pb 5

	def fib(n: Int) : Int={
		if(n==0) 0
		if(n==1) 1
		fib(n-1)+fib(n-2)
	}

//Pb 6

	def fib1(n: Int) : Int={
		if(n==0) 0
		if(n==1) 1
		var t = 0
		var i = 1
		var parent = 0
		var target = 1
		while (i<n){
			t=target
			target=parent+target
			parent=t
			i=i-1;
		}
 	target
	}

//Pb 7

	def pb7(x : Int, y : Int) ={
		var q = 0
		var r = 0
    var a=x; var b=y
		while(a>=b){
			a=a-b
			q=q+1
		}
		r=a
		println(q)
		println(r)
	}

//Pb 8

	def commonDiv(m : Int, n : Int) ={
		var t = 0
    var x=m ; var y = n
		while(y!=0){
			while(x>=y){
				x-=y
			}
			t = x
			x = y
			y = t
		}
		x
	}

//Pb 9

	def nrHits(a : Array[Int]) : Int = {
		val n= a.size; var total=1; var i =1; var hit=a(0)
		while(i<n){
			if(a(i)>hit){
				hit=a(i)
				total=total+1
			}
		i=i+1;
		}
		total
	}
}
/*
Function abstraction:
state s: seq Int
s = list(head.next)
list(null) = []
list(a) = a.datum:L(a.next)
Datatype Invariants : list(head.next) is finite, the names in list(head.next) are distinct and list(head.next) is sorted
*/

