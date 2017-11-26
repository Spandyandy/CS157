import objectdraw.*;
import java.awt.*;

// Animate a falling ball
public class AISolver extends ActiveObject {
    private DrawingCanvas canvas;
    private boolean isFinished = false;
    private int ROWSIZE,FLIPSIZE;
    private FilledRect[][] board;
    private FramedRect[][] border;
    private Text score;
    private double successes = 0;
    private int attempts = 0;
    private double TIME = 1000;
    
    private RandomIntGenerator randGen;
    private Timer timer;
    
    public AISolver(FilledRect[][] aBoard, FramedRect[][] aBorder, int aROWSIZE, int aFLIPSIZE, DrawingCanvas aCanvas){
        canvas = aCanvas;
        ROWSIZE = aROWSIZE;
        FLIPSIZE = aFLIPSIZE;
        board = aBoard;
        border = aBorder;
        timer = new Timer(ROWSIZE, FLIPSIZE, canvas);
        
        start();
    }
    public void run() {
        randGen = new RandomIntGenerator(0,ROWSIZE-1);
        score = new Text ("", 0, FLIPSIZE*ROWSIZE, canvas);
        while(isFinished == false){
             int x = randGen.nextValue();
             int y = randGen.nextValue();
             if(board[x][y].isHidden() == false){
                 border[x][y].setColor(Color.RED);
                 border[x][y].sendToFront();
                 pause(TIME);
             }
                for (int r = 0; r<ROWSIZE; r++){
                    for (int c = 0; c<ROWSIZE; c++){
                     if(board[x][y].getColor() == board[r][c].getColor()){
                         border[r][c].setColor(Color.RED);
                         border[r][c].sendToFront();
                         board[r][c].hide();
                         board[x][y].hide();
                         border[x][y].setColor(Color.BLACK);                  
                     }
                     border[r][c].setColor(Color.BLACK);
                 }
             }                
        }
    }
}
