/**
 * 
 * Andy Kim ( Junghoo)
 * Feb 21, 2016
 * 
 * 
 */
import objectdraw.*;
import java.awt.*;
public class RectTimer extends WindowController {
     public RectTimer(){
         startController(1000, 1000);
        }
        private FilledRect rect;
        RandomIntGenerator randgen = new RandomIntGenerator(0, 950); 
        RandomIntGenerator randcol = new RandomIntGenerator(0, 255);
        private Timer stopWatch;
        private double timeLimit = 5.0;
     public void begin(){
         stopWatch = new Timer();
        rect = new FilledRect( randgen.nextValue(), randgen.nextValue(), 50, 50, canvas);
        rect.setColor(new Color(randcol.nextValue(),randcol.nextValue(),randcol.nextValue()));

         
     }
     public void onMouseClick(Location point){
        if (rect.contains(point)){
         
         canvas.clear();
         new Text(stopWatch.elapsedSeconds() , 500, 100 ,canvas);
         begin();
        }
        else if (stopWatch.elapsedSeconds()>timeLimit){
            canvas.clear();
            begin();
        }
    }
    
    }