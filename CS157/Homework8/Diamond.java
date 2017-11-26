import objectdraw.*;
import java.awt.*;
public class Diamond extends WindowController{
    
    private Line [] diamond = new Line[4];
    
    public Diamond(){
        startController(200, 200);
    }
    
    public void begin(){
        diamond[0] = new Line(100, 0, 200, 100, canvas);
        diamond[1] = new Line(0, 100, 100, 0, canvas);
        diamond[2] = new Line(100, 200, 0, 100, canvas);
        diamond[3] = new Line(200, 100, 100, 200, canvas);
        
        diamond[0].setColor(Color.RED);
        diamond[1].setColor(Color.RED);
    }
}