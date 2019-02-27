package solutions



object pb3{
  
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

        /* Add the name and number to the mapping */
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
Function abstraction:

state s: seq Int
s = list(head.next)
list(null) = []
list(a) = a.datum:L(a.next)

Datatype Invariants : list(head.next) is finite, the names in list(head.next) are distinct and list(head.next) is sorted




*/
