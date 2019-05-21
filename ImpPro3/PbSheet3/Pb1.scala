package solutions

import scala.swing._
import scala.swing.event._

class Dictionary(fname: String){
  /* A Set object holding the words */
  private val words = new scala.collection.mutable.HashSet[String]

  /* Initialise dictionary from fname */
  private def initDict(fname: String) = {
    val allWords = scala.io.Source.fromFile(fname).getLines
    /* Checks if w should be included */
    def include(w:String) = w.forall(_.isLower)
    for(w <- allWords; if include(w)) words += w
  }

  /* Initialise the dictionary */
  initDict(fname)

  /* Checks if w is in the dictionary */
  def isWord(w: String) : Boolean = words.contains(w)
}


object WordPaths{
  /* The dictionary */
  var dict : Dictionary = null

  /* A type representing paths through the graph of words */
  type Path = List[String]

  /* Print the Path path
     Pre: path not empty. */
  def printPath(path: Path) : String = {
    var pathOut = path.head.toString
    for(w <- path.tail) pathOut += "\n" + w
    pathOut + "\n"
  }

  /* Find all neighbours of w */
  def neighbours(w: String) : Path = {
    var result = List[String]()       // stores the neighbours
    for(i <- 0 until w.length; l <- 'a' to 'z')
      if(l != w(i)){
        val w1 = w.patch(i,List(l),1) // replace character on position i of w with l
        if(dict.isWord(w1)) result = w1 :: result
      }
    result
  }

  /*Find a minimum length path from start to target.
    return Some(p) for some shortest Path p if one exists;
    otherwise None. */
  def findPath(start: String, target: String) : Option[Path] = {

    val queue = scala.collection.mutable.Queue(List(start))
    /* Keep track of the words we've already checked */
    val seen = new scala.collection.mutable.HashSet[String]
    seen += start

    while(!queue.isEmpty){
      val path = queue.dequeue; val w = path.head
      for(w1 <- neighbours(w)){
        if(w1==target) return Some((target::path).reverse)
        else if(!seen.contains(w1)){seen += w1; queue += w1::path}
      }
    }
    None  // no solutions
  }
}
object WordPathsSwing extends SimpleSwingApplication {
  def top = new MainFrame {
        title = "WordPaths App"
        var dictFile = "src/main/resources/knuth_words"
        WordPaths.dict = new Dictionary(dictFile)

        val start  = new TextField { columns = 5 }
        val target = new TextField { columns = 5 }

        val button = new Button {
            text = "Calculate Path"
        }

        val label = new TextArea(rows = 10, columns = 30)

        contents = new BoxPanel(Orientation.Vertical) {
            contents += new Label("Start Word: ")
            contents += start
            contents += new Label("Target Word: ")
            contents += target
            contents += button
            contents += label
            border = Swing.EmptyBorder(20, 20, 20, 20)
        }

        listenTo(button)
        var nClicks = 0

        reactions += {
            case ButtonClicked(b) =>
              var startt = start.text
              var targett = target.text
              var res = ""
              if(targett== "" ){
                res = "Empty Target\n"
              }
              else if(targett.length != startt.length){
                res = "Lengths are not equal\n"
              }
              else{
                val optPath = WordPaths.findPath(startt, targett)
                optPath match{
                  case Some(path) => res = WordPaths.printPath(path)
                  case None => res = "No path found\n"
                }
              }
              label.text = res
        }
    }
}
/* We use a breadth-first search. Every node of the search graph will be a list of words,
   consecutive words differing in one letter, and ending with start,
   representing a path (in reverse order) */
