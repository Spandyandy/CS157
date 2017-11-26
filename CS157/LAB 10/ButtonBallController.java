import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Menu controls speed of falling ball
public class ButtonBallController extends WindowController implements ActionListener {
    
    // location of instructions
    private static final Location INSTR_LOCATION = new Location(100,25);
    
    private static final int SLOW_SPEED = 2,   // slow setting
                             MEDIUM_SPEED = 4, // medium setting
                             FAST_SPEED = 6,   // fast setting
                             MAXBALLS = 60;
    
    private FallingBall[] droppedBall; // the falling ball
    private int numBall = 0;
    private JButton mediumButton, fastButton, slowButton;
    private JPanel speedChoice;   // Combo box to select ball speed
    private int speed;               // Current speed setting
    
    public ButtonBallController() {
        startController();
    }
    
    // display instructions and combo box
    public void begin() {
        new Text( "Click to make a falling ball...", INSTR_LOCATION, canvas );

        speed = SLOW_SPEED;
        droppedBall = new FallingBall [MAXBALLS];

        slowButton = new JButton("Slow");
        slowButton.addActionListener(this);
        mediumButton = new JButton("Medium");
        mediumButton.addActionListener(this);
        fastButton = new JButton("Fast");
        fastButton.addActionListener(this);
        
        speedChoice = new JPanel();         //construct combo box
        
        speedChoice.add ( slowButton );        // Add 3 entries
        speedChoice.add ( mediumButton );
        speedChoice.add ( fastButton );
        
        Container contentPane = getContentPane(); // Add combo box to south
        contentPane.add( speedChoice, BorderLayout.SOUTH );
        contentPane.validate();
    }
    
    // make a new ball when the player clicks
    public void onMouseClick( Location point ) {
        droppedBall[numBall] = new FallingBall( point, speed, canvas );
        numBall++;
    }
    
    // reset ball speed from combo box setting
    public void actionPerformed( ActionEvent evt ) {
        if ( evt.getSource() == slowButton ) {
            speed = SLOW_SPEED;
        } 
        else if (evt.getSource() == mediumButton) {
            speed = MEDIUM_SPEED;
        } 
        else if (evt.getSource() == fastButton) {
            speed = FAST_SPEED;
        }
        for (int i = 0; i < MAXBALLS; i++) {
            if ( droppedBall[i] != null ) {
                    droppedBall[i].setSpeed( speed );
            }
        }
    }
}