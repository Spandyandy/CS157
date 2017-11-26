
import java.awt.*;
import objectdraw.*;

public class Concentration1 extends WindowController {
    
    public Concentration1(){
        startController(1000, 1000);
    }
    private RandomIntGenerator greyGen;
    private RandomIntGenerator randNum;
    private Color[] greyVals = new Color[12];
    private FilledRect[] boxes = new FilledRect[24];
    private FramedRect[] outlines = new FramedRect[24];
    private boolean paired[] = new boolean[24];
    private boolean clicked = false;
    private int choice1;
    private Text score;
    private int successes = 0;
    private int attempts = 0;
    
    public void begin(){
        greyGen = new RandomIntGenerator(0,255);
        randNum = new RandomIntGenerator(0,23);
        int x = 0;
        for (int i = 0; i<24; i++){
            boxes[i] = new FilledRect(x,0,(canvas.getWidth()/24-2),(canvas.getHeight()/24-2), canvas);
            outlines[i] = new FramedRect(x,0,(canvas.getWidth()/24-1),(canvas.getHeight()/24-1), canvas);
            x = x + canvas.getWidth()/24;
        }
        for (int i = 0; i < 24; i++){
            int index = randNum.nextValue();
            FilledRect a = boxes[index];
            boxes[index] = boxes[i];
            boxes[i] = a;
            FramedRect b = outlines[index];
            outlines[index]= outlines[i];
            outlines[i] = b;
        }
        for (int i=0; i< 12; i++){
            greyVals[i] = new Color(greyGen.nextValue(),greyGen.nextValue(),greyGen.nextValue());
            boxes[i].setColor(greyVals[i]);
            boxes[i+12].setColor(greyVals[i]);
        }
        score = new Text ("Score = " + successes + " out of " + attempts, 0, 500, canvas);
    }
    public void onMouseClick (Location point){
        for (int i = 0; i<24; i++){
            if (boxes[i].contains(point) && clicked == false){
                outlines[i].setColor(Color.RED);
                outlines[i].sendToFront();
                choice1 = i;
                clicked = true;
            }
            else if (boxes[i]!= boxes[choice1] && boxes[i].contains(point) && boxes[i].getColor() == boxes[choice1].getColor()
                            && clicked == true){
                boxes[choice1].hide();
                boxes[i].hide();
                outlines[i].hide();
                outlines[choice1].hide();
                clicked = false;
                successes++;
                attempts++;
            }
            else if(boxes[i].contains(point)){
                outlines[i].setColor(Color.BLACK);
                outlines[choice1].setColor(Color.BLACK);
                clicked = false;
                attempts++;
            }
        }
        score.setText ("Score = " + successes + " out of " + attempts);
    }
}