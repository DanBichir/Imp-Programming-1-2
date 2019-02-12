

package solutions

trait Stack[A] {
  
  
  /** Adds new element to the stack
    * post: S = x ++ S */
  def push(x : A)

  /** Removes newest element from the stack
    * pre: !isEmpty()
    * post: S = tail S ^ return head S */
  def pop() : A

  /** Checks if empty
    * post: S = S ^ return S == [] */
  def isEmpty()
}
