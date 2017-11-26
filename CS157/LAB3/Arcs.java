/**
 * 
 * 
 */

import objectdraw.*;
import java.awt.*;

public class Arcs extends WindowController {
    private FilledArc fArc1; 
    private FilledArc fArc2; 
    private FilledArc fArc3; 
    public int counter1;
    public int counter2;
    public int counter3;
    public static void main(String args[]) {
   new Arcs().startController(500, 500);
}
    public void begin()
    {
        
     
     fArc1 = new FilledArc(100,100,50,50, 0, 120,canvas);
     fArc1.setColor(new Color(50, 150, 250));
     fArc2 = new FilledArc(100,100,50,50, 120, 120,canvas);
     
     fArc2.setColor(Color.BLUE);
     fArc3 = new FilledArc(100,100,50,50, 240, 120,canvas);
     
     fArc3.setColor(Color.RED);
     
    }
    public void onMouseClick(Location point){
    if(fArc1.contains(point)){
        canvas.clear();
        counter1 = counter1 + 1;
        begin();
}
    if(fArc2.contains(point)){
        canvas.clear();
        counter2 += 1;
        begin();
}
    if(fArc3.contains(point)){
        canvas.clear();
        counter3 ++;
        begin();
}
    new Text(counter1,0,0,canvas);
    new Text(counter2,0,10,canvas);
    new Text(counter3,0,20,canvas);
}
}