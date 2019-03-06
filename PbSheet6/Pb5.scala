package solutions

object pb5{

  //Destructive flip
  def flip(tr: Tree) : Unit = {
    if(tr == null) return
    val k : Tree = tr.left
    tr.left = tr.right
    tr.right = k
    flip(tr.left)
    flip(tr.right)
  }
}
