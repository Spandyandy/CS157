import objectdraw.*;
import java.awt.*;

// a race to demonstrate variability in ActiveObjects
public class StartRace extends WindowController {
    
    private static final double LANESEP = 50;
    
    HotRod top, bottom;
    Text text = new Text("Time : " , 100, 100, canvas);
        
    public StartRace() {
        startController(800, 400);
    }
      
    public static void main (String[] args) {
    new StartRace().startController(800, 400);
    }
    // create two cars at the starting line
    public void begin() {
        Image ac = getImage("racer1.jpg");
        Image ch = getImage("racer2.jpg");
        top = new HotRod( 0, (canvas.getHeight()-LANESEP)/2, Color.RED, this, ac, canvas);
        bottom = new HotRod( 0, (canvas.getHeight()+LANESEP)/2, Color.BLUE, this, ch, canvas);
    }
    
    public void onMouseEnter(Location point) {
        canvas.clear();
        begin();
    }
    
    // Drivers, start your engines
    public void onMouseClick(Location point){
        top.start();
        bottom.start();
    }
    
    // Stop both boxes once either finishes
    public void raceOver(){
        top.freeze();
        bottom.freeze();
    }
}
