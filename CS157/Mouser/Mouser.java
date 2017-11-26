/**
 * to get experience using graphical objects and their methods
 * 
 * @author (Andy Kim) 
 * @version (1/21/2016)
 */

import objectdraw.*;
import java.awt.*;

public class Mouser extends WindowController {
    private FramedRect reset;
    private  FilledOval A ;
     private Text B ;
     private  Text C ;
    public Mouser() 
    {
    startController(800, 600);
    B = new Text( "USER INSTRUCTIONS", 200, 400, canvas );
    B.setFontSize(22); 
    B.setColor( new Color(20, 20, 150));
    new Text( "-------------------------------------------------", 200, 425, canvas );
    new Text( "Enter mouse in window to see a labeled box.", 200, 450, canvas );
    new Text( "Exit mouse from window to see a labeled box.", 200, 475, canvas );
    new Text( "Press mouse to see filled oval.", 200, 500, canvas );
    new Text( "Release mouse to see box around oval.", 200, 525, canvas );
    new Text( "Move mouse to see trail of dots(pixels).", 200, 550, canvas );
    new Text( "Drag mouse to see trail of D's", 200, 575, canvas );
    new Text( "Click 'button' to start over.", 200, 600, canvas );
    new Text( "Click to Reset", 500, 405, canvas );
    reset = new FramedRect( 490, 400, 100, 25, canvas );
    reset.setColor( new Color(15, 30, 200));
}
   public void onMouseEnter(Location point) {
       new FramedRect( 150, 10, 50, 50, canvas );
       new Text( "ENTER!", 153, 27, canvas );
    }
    
   public void onMouseExit(Location point) {
       new FramedRect( 10, 150, 25, 100, canvas );
       new Text( "E", 20, 160, canvas );
       new Text( "x", 20, 180, canvas );
       new Text( "i", 20, 200, canvas );
       new Text( "t", 20, 220, canvas );
    }
    
   public void onMouseDrag(Location point) {
       new Text("D", point, canvas);
    }
    
   public void onMouseClick(Location point) {
       
if (reset.contains(point)) {
    canvas.clear();   // erases everything in the window
    B = new Text( "USER INSTRUCTIONS", 200, 400, canvas );
    B.setFontSize(22); 
    B.setColor( new Color(20, 20, 150));
    new Text( "-------------------------------------------------", 200, 425, canvas );
    new Text( "Enter mouse in window to see a labeled box.", 200, 450, canvas );
    new Text( "Exit mouse from window to see a labeled box.", 200, 475, canvas );
    new Text( "Press mouse to see filled oval.", 200, 500, canvas );
    new Text( "Release mouse to see box around oval.", 200, 525, canvas );
    new Text( "Move mouse to see trail of dots(pixels).", 200, 550, canvas );
    new Text( "Drag mouse to see trail of D's", 200, 575, canvas );
    new Text( "Click 'button' to start over.", 200, 600, canvas );
    B = new Text( "Click to Reset", 500, 405, canvas );
    reset = new FramedRect( 490, 400, 100, 25, canvas );
    B.setColor( new Color(0, 200, 0));
    reset.setColor( new Color(0, 200, 0));
}


    }
    
    
    
   public void onMouseMove(Location point) {
    new Text( ".", point, canvas );
}
    
    
    
    
    
    
 
    
   public void onMousePress(Location point) {
       C = new Text( "HEE", point, canvas );
       A = new FilledOval( 0, 0, 100, 100, canvas);
       A.setColor( new Color(0, 200, 0));
        reset.setColor( new Color(200, 50, 150));
        B = new Text( "Click to Reset", 500, 405, canvas );
        B.setColor( new Color(200, 50, 150));
    }
    
   public void onMouseRelease(Location point) {
       
new FramedRect( 0, 0, 100, 100, canvas );
    }
    
}
