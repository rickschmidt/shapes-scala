package edu.luc.cs.laufer.cs473.shapes

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite

import BoundingBox._
import TestFixtures._

@RunWith(classOf[JUnitRunner])
class TestBoundingBox extends FunSuite {

  def testBoundingBox(description: String, s: Shape, x: Int, y: Int, width: Int, height: Int) = {
    test(description) {
      
	  val b = boundingBox(s)
	  val r = b.shape.asInstanceOf[Rectangle]
	  
	  assert(x === b.x)
	  assert(y === b.y)
	  assert(width === r.width)
	  assert(height === r.height)
    }
    
    
  }
def testSize(description: String, s:Shape,num:Int)={
      test(description){
        val b=size(s)
        
        assert(num===b)
      }
    }
// TODO comment these tests back in


  testBoundingBox("simple ellipse", simpleEllipse, -50, -30, 100, 60)
  testBoundingBox("simple rectangle", simpleRectangle, 0, 0, 80, 120)
  testBoundingBox("simple location", simpleLocation, 70, 30, 80, 120)
  testBoundingBox("basic group", basicGroup, -50, -30, 100, 70)
  testBoundingBox("simple group", simpleGroup, 150, 70, 350, 280)
  testBoundingBox("complex group", complexGroup, 30, 60, 470, 320)

  //Size
  testSize("simple ellipse size",simpleEllipse,1)
  testSize("simple rectangle size", simpleRectangle, 1)
  testSize("simple location size", simpleLocation, 1)
  testSize("basic group size", basicGroup, 2)
  testSize("simple group size", simpleGroup, 2)
  testSize("complex group size", complexGroup,5)
}

