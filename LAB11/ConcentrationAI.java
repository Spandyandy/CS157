/**
 * Concentration - test of memory and visual acuity
 * 
 * @author Andy Kim && Philip Davis
 * @version 03/27/08
 */

import objectdraw.*;
import java.awt.*;
public class ConcentrationAI extends WindowController {

    
    private static final int ROWSIZE = 8; // positive even number
    private static final int FLIPSIZE = 100;
    private RandomIntGenerator randNum;
    private RandomIntGenerator colGen;
    private int selectedRow;
    private int selectedCol;
    private boolean clicked = false;
    private Text score;
    private int successes = 0;
    private int attempts = 0;
    
    private FilledRect[][] board = new FilledRect[ROWSIZE][ROWSIZE];
    private FramedRect[][] border = new FramedRect[ROWSIZE][ROWSIZE];
    private Color[] colors = new Color[ROWSIZE*ROWSIZE/2];
    private Image image;
    
    private Text watch;
    private double startTime = 0;
    private Timer timer;
    
    private AISolver solving;
    
    public static void main (String[] args) {
        new ConcentrationAI().startController(1000, 1000);   
    }
    
    public void begin() {
        randomBackground();
        for (int i = 0; i < ROWSIZE; i++) {
            for (int j = 0; j < ROWSIZE; j++) {
                board[i][j] = new FilledRect(i*FLIPSIZE+1, 
                                   j*FLIPSIZE+1,FLIPSIZE-1, FLIPSIZE-1, canvas);
                border[i][j] = new FramedRect(i*FLIPSIZE, j*FLIPSIZE, FLIPSIZE-0.5, FLIPSIZE-0.5, canvas);
            }
        }
        shuffling();    
        coloring();
        //score = new Text ("Score : " + successes + " / " + attempts, 0, FLIPSIZE*ROWSIZE, canvas);
        
        solving = new AISolver(board, border, ROWSIZE, FLIPSIZE, canvas);
        
    }
    public void randomBackground(){
        randNum = new RandomIntGenerator(0, 2);
        int x= randNum.nextValue();
        if(x == 0)
            image = getImage("phillip.jpg");
        else if(x == 1)
            image = getImage("ANDY.jpg");
        else if(x == 2)
            image = getImage("REESE.jpg");
        new VisibleImage(image,0,0,ROWSIZE*FLIPSIZE,ROWSIZE*FLIPSIZE,canvas);
    }
    public void shuffling(){
        randNum = new RandomIntGenerator(0,ROWSIZE-1);
        for (int i = 0; i < ROWSIZE; i++) {
            for (int j = 0; j < ROWSIZE; j++) {
                int indexi = randNum.nextValue();
                int indexj = randNum.nextValue();
                FilledRect a = board[indexi][indexj];
                board[indexi][indexj] = board[i][j];
                board[i][j] = a;
                FramedRect b = border[indexi][indexj];
                border[indexi][indexj] = border[i][j];
                border[i][j] = b;
            }
        }
    }
    public void coloring(){
        colGen = new RandomIntGenerator(0,255);
        int counter = 0; 
        for (int i = 0; i < ROWSIZE*ROWSIZE/2; i++){
                colors[i] = new Color(colGen.nextValue(), colGen.nextValue(), colGen.nextValue());
        }
        for (int i = 0; i < ROWSIZE; i++){
            for(int j = 0; j < ROWSIZE/2; j++){
                board[i][j].setColor(colors[counter]);
                board[i][j+ROWSIZE/2].setColor(colors[counter]);
                counter++;
            }
        }
    }
    public void onMouseClick(Location pt) {
        int row, col;
        for (row = 0; row < ROWSIZE; row++) {
            for (col = 0; col < ROWSIZE; col++) {
               if (board[row][col].contains(pt) && clicked == false && board[row][col].isHidden() == false) {
                   border[row][col].setColor(Color.RED);
                   border[row][col].sendToFront();
                   selectedRow = row;
                   selectedCol = col;
                   clicked = true;
                   if (attempts == 0)
                   timer = new Timer(ROWSIZE, FLIPSIZE, canvas);
                }
               else if(board[row][col].contains(pt) && clicked == true && board[row][col].isHidden() == false
                       && board[row][col] != board[selectedRow][selectedCol]
                       && board[row][col].getColor() == board[selectedRow][selectedCol].getColor())    {
                    board[row][col].hide();
                    board[selectedRow][selectedCol].hide();
                    border[selectedRow][selectedCol].setColor(Color.BLACK);
                    clicked = false;
                    successes++;
                    attempts++;
                }
                else if(board[row][col].contains(pt) && board[row][col].isHidden()==false){
                    border[row][col].setColor(Color.BLACK);
                    border[selectedRow][selectedCol].setColor(Color.BLACK);
                    clicked = false;
                    attempts++;
                }
            }
        }
        //score.setText ("Score : " + successes + " / " + attempts);
        if(successes == (int)ROWSIZE*ROWSIZE/2){
            timer.astop();
        }
    }    
}