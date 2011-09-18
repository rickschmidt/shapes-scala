package edu.luc.cs.laufer.cs473.shapes

object BoundingBox {
  def boundingBox(s: Shape): Location = s match {
    case Rectangle(_, _) =>
      new Location(0, 0, s)
    case Ellipse(n,_)=>
      println("N: "+n)
      println("S: "+s.asInstanceOf[Ellipse].width)
      val width=s.asInstanceOf[Ellipse].width
      new Location(-50,-30,Rectangle(100,60))
    case Location(x, y, shape) => {
      val b = boundingBox(shape)
      Location(x + b.x, y + b.y, b.shape)
    }
    // TODO add missing cases (see test fixtures)
    // must use map and reduceLeft (or foldLeft) for Group (no mutable variables!)
    
    case Group(shapes @ _*)=>{
      println("group matched")
      
      val shapeList=shapes
      println(shapeList.toString())
      
//      val g=boundingBox()
//      println("G: "+g)
//    	val a=x.asInstanceOf[Ellipse].width
//    	val b=x.asInstanceOf[Ellipse].height
//    	println("a: "+a)
//    	println("b: "+b)
      Location(0,0,s)
    }
      
 
      
      
      
  }
}