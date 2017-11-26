import java.awt.*;
import objectdraw.*;
public class GameOfLife extends Cells {
    public void gameOfLife(){
        while (gameStop != true){
            for (int i=1; i < ROWSIZE-1; i++){
                for (int j=1; j < ROWSIZE-1; j++){
                    live2[i][j] = live1 [i][j];
                    int x=countNeighbors(i,j);
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
