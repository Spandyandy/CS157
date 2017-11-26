import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// Animate a falling ball
public class Clock extends ActiveObject {
    private static final int DELAY_TIME = 1000;
    
    private DrawingCanvas canvas;   
    private double hour, minute, second;
    private double htheta, mtheta, hAngle, mAngle, sAngle, stheta;
    private Line mhand;
        private Line hhand;
        private Line shand;
        private Text text;
    // Draw ball at location and w/speed given in parameters
    public Clock( double h,double m, double s, DrawingCanvas aCanvas) {
        canvas = aCanvas;
        hour = h;
        minute = m;
        second = s;
        mhand= new Line (450, 450,450, 150,canvas);
        hhand = new Line (450, 450, 450, 600,canvas);
        shand = new Line (450, 450, 450, 450, canvas);
        shand.setColor(Color.RED);
        start();
    }
    
    // Move ball down until off of canvas
    public void run() {
        while (minute >=0){
        hAngle = (double)(hour+minute/60)/12;
        htheta = (Math.PI/2)-2*Math.PI*(hAngle);
        hhand.setEnd(450+150*Math.cos(htheta), 450-150*Math.sin(htheta));
        
        mAngle = (double)(minute+second/60)/60;
        mtheta = (Math.PI/2)-2*Math.PI*(mAngle);
        mhand.setEnd(450+300*Math.cos(mtheta), 450-300*Math.sin(mtheta));
        
        sAngle = (double)second/60;
        stheta = (Math.PI/2)-2*Math.PI*(sAngle);
        shand.setEnd(450+200*Math.cos(stheta), 450-200*Math.sin(stheta));
        
        text = new Text((int)hour + ":" + (int)minute + ":" + (int)second, 400,900, canvas);
        text.setFontSize(30);
        text.show();
        second++;
        if (second == 60){
            second = 0;
            minute += 1;
        }
        if (minute == 60){
            minute = 0;
            hour += 1;
        }
        if (hour == 12)
            hour = 0;
        pause(DELAY_TIME);
        text.hide();
    }   
    }
}