import objectdraw.*;
import java.awt.*;
import java.util.Scanner;
public class AnalogClock1 extends WindowController
{
    public static void main(String[] arg) {
     new AnalogClock1();
    }
    public AnalogClock1(){
            startController(1020, 1020);
        }
        private FramedOval circle;
        private Line mhand;
        private Line hhand;
        private Scanner input;
        private Button a; 
        private double h,m;
        private double htheta, mtheta, hAngle, mAngle;
        private Text text;
 public void begin () 
 {  
     input = new Scanner (System.in);
    circle = new FramedOval (100,100,700,700,canvas);
    new FilledOval (440,440,20,20,canvas);
    mhand= new Line (450, 450,450, 150,canvas);
    hhand = new Line (450, 450, 450, 600,canvas);
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
    a = new Button ("enter time", 20,20, 'c',canvas);
    a.setSize(160,35);
    a.setColor(50, 160, 200);
    }
     public void onMouseClick(Location point){
    if (a.contains(point)){
        
        System.out.println ("Enter the time. First the hour: ");
        h = input.nextInt();
         
         
        System.out.println ("Now, the minute: ");
        m = input.nextInt();
        hAngle = (double)h/12;
        htheta = (Math.PI/2)-2*Math.PI*(hAngle);
        hhand.setEnd(450+150*Math.cos(htheta), 450-150*Math.sin(htheta));
        
        mAngle = (double)m/60;
        mtheta = (Math.PI/2)-2*Math.PI*(mAngle);
        mhand.setEnd(450+300*Math.cos(mtheta), 450-300*Math.sin(mtheta));
        
        text = new Text((int)h + ":" + (int)m, 400,900, canvas);
        text.setFontSize(30);
        
     }
}
}