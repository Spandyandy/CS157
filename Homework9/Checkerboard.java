/**
 * 
 * Junghoo Kim (Andy)
 * Part1,2
 * 
 */

import objectdraw.*;
import java.awt.*;
public class Checkerboard extends WindowController{
    private final Color COL1 = Color.RED;
    private final Color COL2 = Color.BLACK;
    
    private FilledRect[][]  board = new FilledRect[8][8];
    private boolean pinkTurn = false;
    private String[][] dataP = new String[8][8];
    private String[][] dataY = new String[8][8];
    
    public Checkerboard(){
        startController(500, 500);
    }
    
    public void begin(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                board[i][j] = new FilledRect( i * 51, j * 51, 49, 49, canvas);
            }
        }
        ColorRect(board, COL1, COL2);
        System.out.printf("\t      Column \t\tRow\n");
    }
    
    public void ColorRect(FilledRect[][] r, Color col1, Color col2){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if((i+j) % 2 == 0){
                    r[i][j].setColor(col1);
                }
                else if((i+j) % 2 == 1){
                    r[i][j].setColor(col2);
                }
            }
        }
    }
    
    public void onMouseClick(Location point){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(board[i][j].contains(point) && pinkTurn == false && dataP[i][j] == null
                                                                    && dataY[i][j] == null){
                    new FilledOval(i* 51,j * 51, 49, 49, canvas).setColor(Color.YELLOW); 
                    pinkTurn = true;
                    dataY[i][j] = ((i+1)+"\t|\t "+(j+1));
                    System.out.printf("Yellow :\t%s\n",dataY[i][j]);
                }
                else if(board[i][j].contains(point) && pinkTurn == true && dataP[i][j] == null
                                                                    && dataY[i][j] == null){
                    new FilledOval(i* 51,j * 51, 49, 49, canvas).setColor(new Color(255,105,180)); 
                    pinkTurn = false;
                    dataP[i][j] = ((i+1)+"\t|\t "+(j+1));
                    System.out.printf("Pink   :\t%s\n",dataP[i][j]);
                }
                
            }
        }
    }
}