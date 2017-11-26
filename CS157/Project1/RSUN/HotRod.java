import java.awt.*;
import objectdraw.*;

public class HotRod extends ActiveObject {
    
    // size of the car
    private static final double BOXSIZE = 50;
    
    // parameters that control speed of car
    private static final double SPEED = 0.4;
    private static final double DELAY = 0.5;
   
    // the box and delay display
    private Text maxDelay;
    
    // the window controller for this program
    private StartRace controller;

    // HotRod components
    private FilledRect body, stripe;
    private FilledOval tire1, tire2, top;
    private VisibleImage driver;
    private FilledRect scoreboard;
    
    // flag used to stop car if it loses the race
    private boolean moving;
    
    // x coordinate where car should stop
    private double finishLine;
    
    // Create a car at the starting line
    public HotRod(double x, double y, Color c, StartRace theController, Image drv, DrawingCanvas canvas) {
        controller = theController;
        
        scoreboard = new FilledRect(200,50, 300, 100, canvas);
        scoreboard.setColor(new Color(160, 255, 10));
        scoreboard.sendToBack();
        
        body = new FilledRect(x,y, BOXSIZE+8, 20, canvas);
        top  = new FilledOval(x+10, y-10, 36, 24, canvas);
        stripe = new FilledRect(x+2,y+8, BOXSIZE+4, 5, canvas);
        
        body.setColor(c);
        top.setColor(c);
        stripe.setColor(Color.white);
        
        tire1 = new FilledOval(x+5, y+15, 15, 15, canvas);
        tire2 = new FilledOval(x+(BOXSIZE-15), y+15, 15, 15, canvas);
        maxDelay = new Text("",350+x,y-80,canvas);
        maxDelay.sendToFront();
        finishLine = canvas.getWidth()  - BOXSIZE;
        new Text("Red Car :  ", 250, 80, canvas).setColor(Color.RED);
        new Text("Blue Car :  ", 250, 130, canvas).setColor(Color.blue);
        
        // get the driver
        //driver = new VisibleImage(drv, x+10, y-10, 20, 20, canvas);
    }
    
    // move each component of the car
    public void move() {
        body.move(SPEED, 0);
        top.move(SPEED, 0);
        tire1.move(SPEED, 0);
        tire2.move(SPEED, 0);
        stripe.move(SPEED, 0);
        //driver.move(SPEED, 0);
    }
    
    // stop a car in its tracks
    public void freeze() {
        moving = false;
    }
    
    // On your mark, get set, go...
    public void run() {
        moving = true;
        double maxPause = 0;
        double lastTime = System.currentTimeMillis();
        double sumTime = 0;
        while (body.getX() < finishLine) {
          double currentTime = System.currentTimeMillis();
          double elapsedTime = currentTime - lastTime;
          sumTime = sumTime + elapsedTime;
          lastTime = currentTime;
          
          // calculate and display max delay length
             maxDelay.setText(sumTime/1000);
             maxPause = elapsedTime;    
          
          move();
          pause( DELAY );
       }
       if (moving) {
          controller.raceOver();
       }
    }
}
