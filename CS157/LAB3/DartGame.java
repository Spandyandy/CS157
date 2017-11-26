
/**
 * Write a description of class DartGame here.
 * 
 * Daniel and Andy
 * 2.11.16
 */

import objectdraw.*;
import java.awt.*;

public class DartGame extends WindowController {
    public DartGame(){
        startController(1024, 768);
    }
    private FilledOval outMostRing;
    private FilledOval midRing;
    private FilledOval centerRing;
    private Button dart;
    private Text title;
    RandomIntGenerator randgenX = new RandomIntGenerator (canvas.getWidth()/2-30, canvas.getWidth()/2+330);
    RandomIntGenerator randgenY = new RandomIntGenerator (canvas.getHeight()/2-30, canvas.getHeight()/2+330);
    private Text score;
    private int counter = 0;
    private int randX;
    private int randY; 
    private Location loc;
    private Text shotHit; 
    public void begin(){
        outMostRing = new FilledOval(canvas.getWidth()/2-150, canvas.getHeight()/2-150 , 300, 300, canvas);
        outMostRing.setColor(new Color(10,10,10));
        midRing = new FilledOval(canvas.getWidth()/2-75 ,canvas.getHeight()/2-75 , 150, 150 ,canvas);
        midRing.setColor(Color.BLUE);
        centerRing = new FilledOval(canvas.getWidth()/2-25 ,canvas.getHeight()/2-25 , 50, 50 ,canvas);
        centerRing.setColor(Color.RED);
        new Text ("100", outMostRing.getX()+ outMostRing.getWidth()/2, outMostRing.getY()+outMostRing.getHeight()/2, canvas).setColor(new Color(255,255,255));
        new Text ("75", midRing.getX()+ midRing.getWidth()/2, midRing.getY()+midRing.getHeight()/5-5, canvas).setColor(new Color(255,255,255));
        new Text ("50", outMostRing.getX()+ outMostRing.getWidth()/2, outMostRing.getY()+outMostRing.getHeight()/8, canvas).setColor(new Color(255,255,255));
        dart = new Button("Click Here for an Poisonous Arrow!", canvas.getWidth()*3/4, canvas.getHeight()*3/4, 0, canvas);
        dart.setColor(102, 240, 18);
        title = new Text("DART GAME", canvas.getWidth()/2-50, 50, canvas);
        title.setFontSize(24);
        score = new Text("Score: " + counter, canvas.getWidth()*3/4, canvas.getHeight()/4, canvas);
        shotHit = new Text("", canvas.getWidth()/2-50, 150, canvas);
 }   
 public void onMouseEnter(Location point){
     canvas.clear();
     begin();
    }
 public void onMouseClick(Location point){
     score.hide();
     if(dart.contains(point)){
         randX = randgenX.nextValue();
         randY = randgenY.nextValue();
         loc = new Location(randX+outMostRing.getX(), randY+outMostRing.getY());
         new Text("X", randX+outMostRing.getX(), randY+outMostRing.getY(), canvas).setColor(Color.GREEN);
         if(centerRing.contains(loc)){
             counter += 100;
             shotHit.setText("EXCELLENT!");
            }
            else if ( midRing.contains(loc)){
                counter +=75;
                shotHit.setText("Great!");
            }
         else if( outMostRing.contains(loc)){
             counter += 50;
             shotHit.setText("Good");
        }
        else{
            shotHit.setText("Miss! You Suck!");
        }
        score = new Text("Score: " + counter, canvas.getWidth()*3/4, canvas.getHeight()/4, canvas);
}
}
}