/**
 * 
 * 
 */

import objectdraw.*;
import java.awt.*;

public class RandomBox extends WindowController {
    RandomIntGenerator randgen = new RandomIntGenerator(40, 240); 
    RandomIntGenerator randcol = new RandomIntGenerator(0, 255); 
    private FilledRoundedRect randrect;
    private FramedRoundedRect randrectframe;
    public int width = randgen.nextValue();
    public int height = randgen.nextValue();
    public int xLocation = 250-width/2;
    public int yLocation = 250-(height/2);
    public int red = randcol.nextValue();
    public int green = randcol.nextValue();
    public int blue = randcol.nextValue();
    public static void main(String args[]) {
   new RandomBox().startController(500, 500);
}
    public void begin()
    {
        canvas.clear();
        randrect = new FilledRoundedRect( xLocation, yLocation, width, height,20,20, canvas);
        randrect.setColor(new Color(red,green,blue));
        new Text(("Red= "+red+" Green= "+green+" Blue= "+blue),0,0,canvas);
        randrectframe = new FramedRoundedRect( xLocation, yLocation, width, height,20,20, canvas);
    }
    public void onMouseClick(Location point) {
        System.out.println("Location = (" + xLocation + ", " + yLocation + ")");
        System.out.println("Height = " + height);
        System.out.println("Width = " + width);
    }
    public void onMouseExit(Location point){
        canvas.clear();
    }
    
    public void onMouseEnter(Location point){
        width = randgen.nextValue();
        height = randgen.nextValue();
        xLocation = 250-width/2;
        yLocation = 250-(height/2);
        red = randcol.nextValue();
        blue = randcol.nextValue();
        green = randcol.nextValue();
        begin();
    }
}