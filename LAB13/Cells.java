import java.awt.*;
import objectdraw.*;

public class Cells extends ActiveObject{
    private boolean [][] live1,live2;
    private FilledRect[][] grid;
    private final int ROWSIZE = 40;
    private boolean gamestop = false;
    
    public Cells(FilledRect[][] bg){
        grid = bg;
        
        live1 = new boolean[ROWSIZE][ROWSIZE];
        live2 = new boolean[ROWSIZE][ROWSIZE];
        for (int i = 0; i < ROWSIZE; i++) {
            for (int j = 0; j < ROWSIZE; j++) {
                if(grid[i][j].getColor().equals(Color.YELLOW))
                    live1[i][j] = true;
                else
                    live1[i][j] = false;
            }
        }
        
        start();
    }
    public int countNeighbors(int i, int j){
        int counter = 0;
        if(live1[i-1][j-1]==true){
                    counter ++;
        }
        if(live1[i-1][j]==true){
                    counter ++;
                }
        if(live1[i-1][j+1]==true){
                    counter ++;
                }
        if(live1[i][j-1]==true){
                    counter ++;
                }
        if(live1[i][j+1]==true){
                    counter ++;
                }
        if(live1[i+1][j-1]==true){
                    counter ++;
                }
        if(live1[i+1][j]==true){
                    counter ++;
                }
        if(live1[i+1][j+1]==true){
                    counter ++;
                }
                
        return counter;
    }
    public void gameStop(){
        gamestop = true;
    }
    public void run(){
        int i ,j;
        while(gamestop != true){
            for (i = 1; i < ROWSIZE-1; i++) {
                for (j = 1; j < ROWSIZE-1; j++) {
                    live2[i][j] = live1[i][j];
                    int x = countNeighbors(i,j);
                    if(live1[i][j] == true){
                        if(x<2 || x>3){
                            live2[i][j] = false;
                            grid[i][j].setColor(Color.BLUE);
                        }
                    }
                    if(live1[i][j] == false){
                        if(x == 3){
                            live2[i][j] = true;
                            grid[i][j].setColor(Color.YELLOW);
                        }
                    }              
                }
            }
            for(i = 1; i < ROWSIZE-1; i++) {
                for (j = 1; j < ROWSIZE-1; j++) {
                    live1[i][j] = live2[i][j];
                }
            }
            pause(1000);
        }
    }
}