package solutions


object pb4 {
  class Triangle
  class OpaqueTriangle extends Triangle
  class Renderer {
    def accept(a: Triangle) = println("Accepted for rendering.")
  }
  class RayTracingRenderer extends Renderer {
    def accept(a: OpaqueTriangle) = println("Accepted for ray-trace rendering.")
  }
}


object pb4v2 {
  class Triangle
  class OpaqueTriangle extends Triangle
  class Renderer {
    def accept(a: Triangle) = println("Accepted for rendering.")
  }
  class RayTracingRenderer extends Renderer {
    override def accept(a: Triangle) = println("Accepted for ray-trace rendering.")
  }
}


/*
Renderer has RayTracingRenderer as subclass and both have the function accept, overloading the function.

The function from the parrent class will take priority if the object type is the parent object.
Otherwise, if the object type is child object then it will call the child version of the function.


The solution is to override the function while changing back its signature type, avoiding overloading.

*/
