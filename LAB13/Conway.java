import objectdraw.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Conway extends WindowController
                     implements ActionListener{
    private final int ROWSIZE = 40;
    private FilledRect[][] background = new FilledRect[ROWSIZE][ROWSIZE];
    private FramedRect[][] border = new FramedRect[ROWSIZE][ROWSIZE];
    
    private JPanel southPanel=new JPanel();
    private JButton startButton, stopButton;
    private Cells game;
    
    public Conway(){
        startController(1000, 1000);
    }
    
    public void begin(){
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        southPanel.add(startButton);
        southPanel.add(stopButton);
        Container contentPane = getContentPane();
        contentPane.add(southPanel, BorderLayout.SOUTH);
        contentPane.validate();
        startButton.addActionListener(this);
        stopButton.addActionListener(this);
        
        for (int i = 0; i < ROWSIZE; i++) {
            for (int j = 0; j < ROWSIZE; j++) {
                background[i][j] = new FilledRect(i*20+1, 
                                   j*20+1,19, 19, canvas);
                background[i][j].setColor(Color.BLUE);
                border[i][j] = new FramedRect(i*20, j*20, 20-0.5, 20-0.5, canvas);
                
            }
        }
        
    }
    
    public void onMouseClick( Location point ){
        for (int row = 0; row < ROWSIZE; row++) {
            for (int col = 0; col < ROWSIZE; col++) {
                if(background[row][col].contains(point) && background[row][col].getColor().equals(Color.BLUE)){
                    background[row][col].setColor(Color.YELLOW);
                }
                else if(background[row][col].contains(point) && background[row][col].getColor().equals(Color.YELLOW)){
                    background[row][col].setColor(Color.BLUE);
                }
            }
        }
        
    }
    
    public void actionPerformed( ActionEvent evt ) {
        if ( evt.getSource() == startButton ) {
            game = new Cells(background);
        } 
        else if (evt.getSource() == stopButton) {
            game.gameStop();
        }
    }
    
}