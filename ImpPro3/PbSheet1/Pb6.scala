/*
a) As a subclass, Planetext has access to private variables and methods of Text class.
If we use an instance variable of text, we would lose access to these and we may require additional methods

b) We create a trait that would define all required methods for transmit function to work.
Both classes will extend this trait.

*/
package solutions

object pb6{
  trait toSend{

  }
  def transmit(text: toSend): Unit ={

  }
}
/*
c) Our changes eliminate a loose coupling and create new methods to cover the lost access to both data and methods.

Through this, the main advantage is that we remove  a fragile base class (less expected to errors)

However, we will need to implement new methods to cover this bond, which will make the code more difficult to understand/review(and much longer).
*/
