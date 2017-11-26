
/**
 * Write a description of class Scribble here.
 * 
 * @author Andy Kim
 * @version 1/14/2016
 */
   import objectdraw.*;
   import java.awt.*;
   
   public class Scribble extends WindowController{
       private Location firstPt;
       
       public Scribble() 
       {
           startController(400, 400);
             }

  public void onMousePress(Location pt) {
     firstPt = pt;
  }

  public void onMouseDrag(Location pt) {
     new Line(firstPt, pt, canvas);
     firstPt = pt;
  }

}
