import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// Control speed of falling ball with slider
public class SliderBallController extends WindowController
                                  implements ChangeListener{
    
    private static final int SLOW_SPEED = 0,  // min speed
                             FAST_SPEED = 10;  // max speed
    
    private FallingBall droppedBall; // the falling ball
    
    private int speed = SLOW_SPEED;  // speed of ball
    
    private JSlider speedSlider;
    private JPanel speedChoice;
    private JLabel speedLabel;
    
    public SliderBallController() {
        startController(400, 600);
    }
    
    // construct and add GUI items
    public void begin() {
        speedSlider = new JSlider (JSlider.HORIZONTAL, SLOW_SPEED,
                                    FAST_SPEED, SLOW_SPEED);
        speedSlider.addChangeListener(this);
        
        speedLabel = new JLabel("Speed  is  " + speed, JLabel.RIGHT);
        
       
        speedChoice = new JPanel(); 
        speedChoice.add( speedLabel );
        speedChoice.add( speedSlider );
        
        Container contentPane = getContentPane();
        contentPane.add(speedChoice, BorderLayout.SOUTH );
        //contentPane.add(speedSlider, BorderLayout.SOUTH );
        
        contentPane.validate();
    }
    
    // make a new ball when the player clicks
    public void onMouseClick( Location point ) {
        droppedBall = new FallingBall( point, speed, canvas );
    }
    
    public void stateChanged (ChangeEvent evt) {
        speed = speedSlider.getValue();
        if (droppedBall != null) {
            droppedBall.setSpeed(speed);
        }
        speedLabel.setText("Speed  is  "+ speed);
    }
}