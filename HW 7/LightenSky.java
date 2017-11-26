import objectdraw.*;
import java.awt.*;
public class LightenSky extends ActiveObject{
    private static final int DELAY_TIME = 100;
    private static final double Y_STEP = -5;
    
    private FilledRect sky;
    private int brightness;
    private FilledOval sun;
    private DrawingCanvas canvas;
    private boolean moving;
    
    public LightenSky(int initialBrightness, DrawingCanvas aCanvas){
        canvas = aCanvas;
        brightness = initialBrightness;
        
        sky = new FilledRect(0, 0, canvas.getWidth(), canvas. getHeight(), canvas);
        sky.setColor( new Color( brightness, brightness, brightness));
        
        sun = new FilledOval(50,190,100,100, canvas);
        sun.setColor(Color.RED);
        
        moving = true;
        start();
    }
    
    public void run(){
        while(moving && sun.getY() > 0){
            brightness = brightness + 4;
            sky.setColor(new Color(brightness, brightness, brightness));
            sun.move(0, Y_STEP);
            pause(DELAY_TIME);
        }
    }
    
    public void stopRising(){
        moving = false;
    }
}