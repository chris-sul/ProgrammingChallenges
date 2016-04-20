//Christopher Sullivan
// Creates a snowflake with three koch curves arranged in a triangle

import gpdraw.*;

public class KochCurve
{
	//create the drawing tool objects
	 private SketchPad myPaper;
	 private DrawingTool myPencil;

	 public KochCurve()
	 {
	   //fill the objects
	   myPaper = new SketchPad(600,600);
	   myPencil = new DrawingTool(myPaper);
  }

	 public void draw()
	 {
		 //call recursive function to make a koch curve and put it in a triangle
	   myPencil.setDirection(0);
	   drawKochCurve(6, 300);
	   myPencil.turnRight(120);
	   drawKochCurve(6, 300);
	   myPencil.turnRight(120);
	   drawKochCurve(6, 300);
	 }

	 private void drawKochCurve(double level, double sideLength)
	 {
	   if(level < 1)
	      myPencil.forward(sideLength);

	   else
    {
	     drawKochCurve(level - 1, (sideLength)/3);
      myPencil.turnLeft(60);
      drawKochCurve(level - 1, (sideLength)/3);
      myPencil.turnRight(120);
      drawKochCurve(level - 1, (sideLength)/3);
	     myPencil.turnLeft(60);   
	     drawKochCurve(level - 1, (sideLength)/3);
    }
}
}

