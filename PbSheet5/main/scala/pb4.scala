package solutions


object pb4{
    object linkedList{
        private class Node(val name:String, var number:String, var next:Node)
    }
      
    class linkedList extends Book{
        private var list : linkedList.Node =  new linkedList.Node("?","?",null)

        /* Find the node with the name */
        private def findpre(name:String) : linkedList.Node = {
            var n = list
            while(n.next != null && n.next.name <= name) n = n.next
            return n
        }

        private def find(name:String) : linkedList.Node = {
            findpre(name).next
        }

        /* Find number based on name */
        def recall(name: String) : String = {
            val n = find(name)
            assert(n!=null)
            return n.number
        }

        /* Add the name and number */
        def store(name: String, number: String) = {
            val n = find(name)
            if(n.name != name){
              var prev = findpre(name)
              prev.next = new linkedList.Node(name, number, prev.next)
            }
            else n.number = number
        }
        
         /* Check for name */
        def check(name: String): Boolean = find(name) != null

        /* Remove name from mapping */
        def remove(name: String) = {
            if(check(name)){
              var n = findpre(name)
              n.next = n.next.next
            }
        }
    }
}



/*
a)

E(X)=sum(p(i)*(i*c)) + q*(n*c)
We have the sequences p(i) that we can rearrange. 
The mininum of our expectation is achieved when we pair the greatest values of p(i) with the smallest values of i*c and smallest with greatest.
Assume p(i)<p(j) for i<j, then p(i)*i*c + p(j)*j*c > p(j)*i*c + p(i)*j*c => p(i)>p(j) for i<j

*/
