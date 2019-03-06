package solutions

import scala.collection.mutable.Stack


case class Tree(var word: String, var left: Tree, var right: Tree);

object pb4{

  //Recursive method
  def printTree1( tr: Tree, depth:Int = 0) : String = {
    var s = ""
    s += " . " * depth
    if(tr == null)   s+= "null\n"
    else{
      s += tr.word
      s += "\n"
      s += printTree1(tr.left,depth+1)
      s += printTree1(tr.right,depth+1)
    }
    s
  }

  //Stack method
  def printTree2( tr: Tree) : String = {
    var stack = Stack[(Tree,Int)]()
    stack.push((tr,0))
    var s = ""
    while(!stack.isEmpty){
      var (pos,d) = stack.pop
      s += (" . " * d)
      if(pos == null)s +=  "null\n"
      else{
        s += pos.word + "\n"
        stack.push((pos.right,d+1))
        stack.push((pos.left,d+1))
      }
    }
    s
  }
}
