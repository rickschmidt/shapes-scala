package edu.luc.cs.laufer.cs473.shapes

abstract class Shape

case class Rectangle(width: Int, height: Int) extends Shape
case class Ellipse(width: Int, height: Int) extends Shape{
//	 val e=Ellipse(width,height)
	 
}
case class Location(x: Int, y: Int, shape: Shape) extends Shape {
  if (shape == null) {
    throw new IllegalArgumentException("null shape in location")
  }
}
case class Group(shape: Shape*) extends Shape{
//  val shapeList=shape
//  println(shapeList.toString())
}




//TODO add missing case classes (see test fixtures)
// TODO must include validity checking for constructor arguments

	