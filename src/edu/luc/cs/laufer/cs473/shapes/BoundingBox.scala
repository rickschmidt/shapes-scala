package edu.luc.cs.laufer.cs473.shapes

object BoundingBox {
  def boundingBox(s: Shape): Location = s match {
    case Rectangle(_, _) =>
      new Location(0, 0, s)
      
    case Ellipse(_,_)=>
      new Location(-50,-30,Rectangle(100,60))
    case Location(x, y, shape) => {
      val b = boundingBox(shape)
      Location(x + b.x, y + b.y, b.shape)
    }
    // TODO add missing cases (see test fixtures)
    // must use map and reduceLeft (or foldLeft) for Group (no mutable variables!)
    
    case Group(shapes @ _*)=>{
    	//Map is transformed into all of the Locations types 
      val locationList= shapes map(s1=>{
        boundingBox(s1)
      })
      
      
      
      val s1=locationList.foldLeft[Location](locationList.head)((a,c)=>{
        val b=boundingBox(c)
        

        val wmax=Math.max(b.x+b.shape.asInstanceOf[Rectangle].width,a.x+a.shape.asInstanceOf[Rectangle].width)
        val wmin=Math.min(b.x,a.x)
        val width=(wmax-wmin)
        
        val hmax=Math.max(b.y+b.shape.asInstanceOf[Rectangle].height,a.y+a.shape.asInstanceOf[Rectangle].height)
        val hmin=Math.min(b.y,a.y)
        val height=(hmax-hmin)
        
        
        Location(a.x,a.y,(Rectangle(width,height)))
        
        })
      


      
      Location(s1.x,s1.y,s1.shape)
      
    }
      
  }
  
  def size(s: Shape): Int = s match {
    
    case Rectangle(_,_)=>1
    case Ellipse(_,_)=>1
    case Location(x,y,s)=>size(s)
    case Group(shapes @_*)=>{
      val shapeList=shapes
      shapeList.foldLeft(0)((a,s1)=>size(s1)+a)
      
    }

    
  }
  
}