/**
 * RSun - ActiveObject version of Rising Sun
 * 
 * 
 * 
 * @author spc
 * @version long time ago
 */




import objectdraw.*;
import java.awt.*;

class RSun extends ActiveObject {
    
   public static int DELAY = 1000; // delay in milliseconds
   public FilledOval sun;
   private DrawingCanvas canvas;
   
   public RSun(DrawingCanvas dc) {
       canvas = dc;
       sun = new FilledOval(100, 200, 100, 100, canvas);
       sun.setColor(Color.YELLOW);
       start();
    }
    
    public void run() {
        while (sun.getY() > 5) {
            sun.move(0, -30);
            pause(DELAY);
        }
        pause(1000); // wait a minute
        sun.removeFromCanvas();
    }
    
    public void reset() {
        sun.moveTo(100, 200);
    }
   
}