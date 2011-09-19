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
//      shapes.map(s=>boundingBox(s))
//      shapes.map(s1=>(shapes.foldLeft[Location](Location(0,0,s))(s2,s1)=>(s1=>boundingBox(s1))))
      
      
//      shapeList.map(s1=>
//        shapes.foldLeft[Location](Location(80,30,s1))(((s2,s1)=>
//          boundingBox(s2)))
//          )
//      
//      val sf=shapeList map(s1=>shapeList.foldLeft[Location](Location(-50,-30,s))((s2,s1)=>{
//        println("s1: "+s1)
//        
//         val b=(boundingBox(s1))
//         println("bx: "+(b.x))
//         println("s2.x: "+s2.x)
//         Location(shapeList.head.asInstanceOf[Location].x-50,shapeList.head.asInstanceOf[Location].y-30,b.shape)}
//      ))
      
//      val sf=shapeList map(s1=>{
//        val b=boundingBox(s1)
//        val r=b.shape.asInstanceOf[Rectangle]
//           
//           shapeList.foldLeft[Location](Location(0,0,b))((s2,s1)=>{
//             println("s1 in fold: "+s1)
//             println("s2 in fold: "+s2)
////             println("s1 in fold: "+(s1.asInstanceOf[Rectangle].width))
//             val b=(boundingBox(s2))
//             val b1=(boundingBox(s1))
//             
//             val wmax=Math.max(b.x+b.shape.asInstanceOf[Rectangle].width,b1.x+b1.shape.asInstanceOf[Rectangle].width)
//             val wmin=Math.min(b.x,b1.x)
//             val width=wmax-wmin
//             
//             val hmax=Math.max(b.y+b.shape.asInstanceOf[Rectangle].height,b1.y+b1.shape.asInstanceOf[Rectangle].height)
//             val hmin=Math.min(b.y,b1.y)
//             val height=hmax-hmin
//             println("width: "+width)
//             println("height: "+height)
//             val s3=boundingBox(s1)
////             s3.asInstanceOf[Rectangle].width+width
//             s2.asInstanceOf[Location].x+width
//             s2.asInstanceOf[Location].y+height
//             s2.asInstanceOf[Location]
//             
//             println("b2: "+s2.shape)
//             Location(b.x,b.y,(b.shape))
//             })
//           
//           println("shapelistafterfold"+shapeList)
//        Location(b.x,b.y,b.shape)
//      })
//      
      
      
//      val sf=shapeList.map(s1=>shapeList.foldLeft(0)((s2,s1)=>(
//          boundingBox(s1)).x))
//    		  	println("shapelist: "+shapeList)
//    		  	println("sf "+(sf.head))
//    		  	val head=sf.head.asInstanceOf[Location]
//    		  	   println("head "+head)
//    		  	head
//       sf.head.asInstanceOf[Location]
//    		  	Location(sf.head,0,Rectangle(-50,0))
      //list.foldLeft[A](list.head)((_, c) => c)
//      println("s2: "+)
      

//      println("shapes after: "+shapeList)
      
//      val g=boundingBox()
//      println("G: "+g)
//    	val a=x.asInstanceOf[Ellipse].width
//    	val b=x.asInstanceOf[Ellipse].height
//    	println("a: "+a)
//    	println("b: "+b)
//      new Location(-50,-30,Rectangle(100,70))
//      	new Location(0,0,Rectangle(0,0))
//      new Location(s.asInstanceOf[Rectangle].width,s.asInstanceOf[Rectangle].height,s)
      
    }
      
 
      
      
      
  }
}