import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Control speed of falling ball with up and down arrow keys
public class KeyBallController extends WindowController implements KeyListener {
    
    private static final int SLOW_SPEED = 1,
                             FAST_SPEED = 10;  // initial speed
    
    private FallingBall droppedBall; // the falling ball
    private int speed = SLOW_SPEED;  // speed of ball
    private JLabel speedLabel;       // label showing speed
    
    public KeyBallController() {
        startController(400, 600);
    }
    // construct and add GUI items
    public void begin() {
        JPanel southPanel = new JPanel();
        speedLabel = new JLabel( "The speed is "+speed, JLabel.CENTER );
        southPanel.add( speedLabel );

        Container contentPane = getContentPane();
        contentPane.add( southPanel, BorderLayout.SOUTH );
        contentPane.validate();

        canvas.addKeyListener ( this );
        this.addKeyListener ( this );
        requestFocusInWindow();
    }
    
    // make a new ball when the player clicks
    public void onMouseClick( Location point ) {
        droppedBall = new FallingBall( point, speed, canvas );
    }
    
    // Required by KeyListener Interface but not used here.
    public void keyTyped( KeyEvent e ) { }

    // Required by KeyListener Interface but not used here.
    public void keyReleased( KeyEvent e ) { }

    // Change speed with up and down arrow keys
    public void keyPressed( KeyEvent e )
    {
        if ( e.getKeyCode() == KeyEvent.VK_UP && speed < FAST_SPEED) 
            speed++;                                                    
        else if ( e.getKeyCode() == KeyEvent.VK_DOWN && speed > SLOW_SPEED) 
            speed--;                                            
        if ( droppedBall != null ) 
            droppedBall.setSpeed( speed );
        speedLabel.setText( "The speed is "+speed );
    }       
}