package edu.luc.cs.laufer.cs473.shapes

object BoundingBox {
  def boundingBox(s: Shape): Location = s match {
    case Rectangle(_, _) =>
      new Location(0, 0, s)
      
    case Ellipse(n,_)=>
//      println("N: "+n)
//      println("S: "+s.asInstanceOf[Ellipse].width)
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
//      println(shapeList.toString())
      	println("shapes before : "+shapes)
      val list=List
      var array=Array
     val locationList= shapeList map(s1=>{
        boundingBox(s1)
      })
      
      locationList.foreach(s1=>println(s1))
      
      val x=locationList.foldLeft[Location](locationList.head)((a,c)=>{
        val b=boundingBox(c)
        println("b: "+b)
        println("a: "+a)
//        val wmax=Math.max(b.x+b.shape.asInstanceOf[Rectangle].width,b1.x+b1.shape.asInstanceOf[Rectangle].width)
//             val wmin=Math.min(b.x,b1.x)
//             val width=wmax-wmin
        val wmax=Math.max(b.x+b.shape.asInstanceOf[Rectangle].width,a.x+a.shape.asInstanceOf[Rectangle].width)
        val wmin=Math.min(b.x,a.x)
        val width=(wmax-wmin)
        
        val hmax=Math.max(b.y+b.shape.asInstanceOf[Rectangle].height,a.y+a.shape.asInstanceOf[Rectangle].height)
        val hmin=Math.min(b.y,a.y)
        println("hmax"+hmax+" hmin "+hmin)
        val height=(hmax-hmin)
        
        println("wmin: "+wmin+"hmin"+hmin)
        println("Width: "+width)
        println("Height: "+height)
        println("a: "+a)
        
        Location(a.x,a.y,(Rectangle(width,height)))
        
        })
      
      println("here")
      x

      
    }
      
  }
  
  def size(s: Shape): Int = s match {
    
    case Rectangle(_,_)=>1
    	1
    
    
    case Ellipse(_,_)=>1
      
    
    
    case Location(x,y,s)=>size(s)
      
    
    
    case Group(shapes @_*)=>{
      val shapeList=shapes
      shapeList.foldLeft(0)((a,s1)=>size(s1)+a)
      
    }

    
  }
  
}