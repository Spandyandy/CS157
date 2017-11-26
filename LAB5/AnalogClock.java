
/**
 * Write a description of class ClockWindow here.
 * 
 * @author (Reese and Andy) 
 * @version (2/18/16)
 */
import objectdraw.*;
import java.awt.*;
import java.util.Scanner;
public class AnalogClock extends WindowController
{
    public static void main(String[] arg) {
     new AnalogClock();
    }
    public AnalogClock()
    {
            startController(1020, 1020);
    }
    
    private FramedOval circle;
    private Scanner input;
    private double h, m;
    private double htheta, mtheta, hAngle, mAngle;
    private Text text;
    private Clock timer;
    private long totalMilliSeconds = System.currentTimeMillis();
    private long totalSeconds = totalMilliSeconds/1000;
    private long second = totalSeconds%60;
    private long totalMinutes = totalSeconds/60;
    private long minute = totalMinutes % 60;
    private long totalHours = totalMinutes / 60; 
    private long hour = (24 -totalHours % 24);
    
    public void begin() 
    {  
         input = new Scanner (System.in);
         circle = new FramedOval (100,100,700,700,canvas);
         new FilledOval (440,440,20,20,canvas);
         new Text ("12", 445,80,canvas);
         new Text ("1", 625,125,canvas);
         new Text ("2", 760,260,canvas);
         new Text ("3", 820,450,canvas);
         new Text ("4", 760,640,canvas);
         new Text ("5", 625,775,canvas);
         new Text ("6", 445,820,canvas);
         new Text ("7", 265,775,canvas);
         new Text ("8", 130,640,canvas);
         new Text ("9", 80,450,canvas);
         new Text ("10", 130,260,canvas);
         new Text ("11", 265,125,canvas);
         timer = new Clock((hour-5)%24, minute, second, canvas);
    }
}
