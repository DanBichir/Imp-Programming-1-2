package solutions

import scala.collection.mutable.Stack
import scala.math.{min,max}

// Representation of a bag of words by using binary tree
object pb6 {
// Companion object defines the type of trees
  object BinaryTreeBag{
    private class Tree(var word: String, var count: Int, var left: Tree, var right: Tree)
  }

  class BinaryTreeBag{
    private type Tree = BinaryTreeBag.Tree // Shorten name
    private def Tree(word: String, count: Int, left: Tree, right: Tree) = new BinaryTreeBag.Tree(word, count, left, right)

    private var root : Tree = null
    // It represents the bag with n.count copies of n.word, for each
    // node n, which can be found by using left and right references.
    // Datatype invariant: the tree is ordered by word fields.

    def findmaxminr() : (Int,Int) = {
      findmaxmin1(root)
    }

    def findmaxmins() : (Int,Int) = {
      findmaxmin2(root)
    }
    // Recursive method
    def findmaxmin1(tr : Tree, depth : Int = 0) : (Int,Int) = {
      if(tr == null)
        return (depth,depth)
      val (lmin,lmax) = findmaxmin1(tr.left)
      val (rmin,rmax) = findmaxmin1(tr.right)
      return (min(lmin,rmin), max(lmax,rmax))
    }
    // Stack method
    def findmaxmin2(t: Tree) : (Int,Int) = {
      var m = 1000000000
      var M = 0
      var stack = Stack[(Tree,Int)]()
      stack.push((t,0))
      while(!stack.isEmpty){
        var (pos,depth) = stack.pop
        if(pos != null){
          stack.push((pos.left ,depth+1))
          stack.push((pos.right,depth+1))
        }
        else{
          m = min(m,depth)
          M = max(M,depth)
        }
      }
      (m,M)
    }
    
    // Find count of a word
    // Recursive method
    private def count1(word: String, tr: Tree) : Int =
      if(tr == null) 0
      else if(word == tr.word) tr.count
      else if(word < tr.word) count1(word, tr.left)
      else count1(word, tr.right)

    // Find count of a word
    // Iterative method
    def count2(word: String) : Int = {
      var tr = root
      // Invariant:
      // for all ti: if ti in T(root) and ti.word = word,
      // then ti in T(t)
      while(tr != null && tr.word != word)
        if(word < tr.word) tr = tr.left
        else               tr = tr.right
      if(tr == null) 0 else tr.count
    }

    // Add an occurrence of word to the tree and returns the new tree.
    // Recursive method
    private def add1(word: String, tr: Tree) : Tree = {
      if(tr == null)            Tree(word, 1, null, null)
      else if(word == tr.word)  { tr.count += 1; tr }
      else if(word < tr.word)   { tr.left  = add1(word, tr.left);  tr }
      else                      { tr.right = add1(word, tr.right); tr }
    }

    // Add an occurrence of word to the tree
    // Iterative method
    def add2(word: String) = {
      if(root==null) root = Tree(word, 1, null, null)
      else{
        var tr = root
        // Invariant: inserion of the word to tree
        while(word < tr.word && tr.left != null || word > tr.word && tr.right != null){
          if(word < tr.word) tr = tr.left else tr = tr.right
        }
        if(word == tr.word) tr.count += 1
        // tr.left or tr.right is null
        else if(word < tr.word) tr.left  = Tree(word, 1, null, null)
        else                    tr.right = Tree(word, 1, null, null)
      }
    }


    //Print the contents of the bag tree
    def printBag = print1(root)

    // Print the contents of a tree
    // Recursive method
    private def print1(tr: Tree) : Unit = {
      if(tr!=null){
        print1(tr.left)
        println(tr.word+" -> "+tr.count)
        print1(tr.right)
      }
    }


    // Print the contents of a tree
    // Iterative method
    def print2 = {
      var tr = root
      val stack = new scala.collection.mutable.Stack[Tree]

      // Invariant: tr has to be printed. For each tree t in the stack, the data in the top node and the data in the nodes of the right subtree have to be printed
      // They are printed based on the order of the stack
      while(tr != null || !stack.isEmpty){
        if(tr != null){
          stack.push(tr)
          tr = tr.left
        }
        else{
          val t = stack.pop
          println(t.word+" -> "+t.count)
          tr = t.right
        }
      }
    }

    // Delete one occurrence of word from the tree.
    def delete(word: String) : Unit = root = delete1(word, root)

    // Delete one occurrence of word from the tree returning the resulting tree.
    // Recursive method
    private def delete1(word: String, tr: Tree) : Tree =
      if(tr == null) null
      else if(word < tr.word)  { tr.left  = delete1(word, tr.left); tr }
      else if(word > tr.word)  { tr.right = delete1(word, tr.right); tr }
      else if(tr.count > 1)    { tr.count -= 1; tr }
      // delete the contents of this node
      else if(tr.left == null)  tr.right
      else if(tr.right == null) tr.left
      else{
        val (w, c, changedr) = delMin(tr.right)
        tr.word = w
        tr.count = c
        tr.right = changedr
        tr
      }

    // Delete the minimum node of the tree
    // Return the word and count from that node and the new tree.
    // Precondition: Tree != null
    private def delMin(tr: Tree) : (String, Int, Tree) ={
      if(tr.left==null) (tr.word, tr.count, tr.right)
      else{
        val (w, c, changedl) = delMin(tr.left)
        tr.left = changedl
        (w, c, tr)
      }
    }

    def countTotal() : Int = {
      count1(root)
    }

    //Recursive method
    def count1(tr : Tree) : Int = {
      if(tr == null)
        return 0
      tr.count + count1(tr.left) + count1(tr.right)
    }

    //Stack method
    def count2() : Int = {
      var n = 0
      var stack = Stack[Tree]()
      stack.push(root)
      //Invariant: n = sum of (visited, count)
      while(!stack.isEmpty){
        var pos = stack.pop
        if(pos != null){
          n += pos.count
          stack.push(pos.left)
          stack.push(pos.right)
        }
      }
      n
    }
  }
}
