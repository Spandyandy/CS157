import objectdraw.*;
import java.awt.*;

// Animate a falling ball
public class Timer extends ActiveObject {
    private Text watch;
    private DrawingCanvas canvas;
    private long startTime;
    private boolean isFinished = false;
    private boolean victory = false;
    private int y,ROWSIZE,FLIPSIZE;
    public Timer(int aROWSIZE, int aFLIPSIZE, DrawingCanvas aCanvas){
        canvas = aCanvas;
        ROWSIZE = aROWSIZE;
        FLIPSIZE = aFLIPSIZE;
        watch = new Text("Time : " ,0, y =(ROWSIZE)*FLIPSIZE+50, canvas );
        startTime = System.currentTimeMillis();
        start();
    }
    public void run() {
        new Text("Time Limit : " + (ROWSIZE*ROWSIZE-ROWSIZE*3/2) + " seconds" , 0, y-20, canvas);
        while((((System.currentTimeMillis()-startTime)/1000)%60)<=60){
            watch.setText("Time : " + (((System.currentTimeMillis()-startTime)/1000)%60));
            pause (1000);
            if(isFinished==true){
                victory = true;
                break;
            }
        }
    }
    public void astop() {
        watch.setText("Time : " + (((System.currentTimeMillis()-startTime)/1000)%60));
        isFinished = true;
        if((((System.currentTimeMillis()-startTime)/1000)%60)>(ROWSIZE*ROWSIZE-ROWSIZE*3/2))
        new Text("TIME OVER", FLIPSIZE, (ROWSIZE)*FLIPSIZE+FLIPSIZE/2, canvas).setFontSize(10*ROWSIZE);
        else
        new Text("VICTORY", FLIPSIZE, (ROWSIZE)*FLIPSIZE+FLIPSIZE/2, canvas).setFontSize(10*ROWSIZE);
    }
}