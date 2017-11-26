import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Control speed of falling ball with up and down arrow keys
public class SnakeController extends WindowController implements KeyListener {
    
    private static final int SLOW_SPEED = 1,
                             FAST_SPEED = 10;  // initial speed
    
    private SnakeBall snakeBall1, snakeBall2;
    private RedBall redBall3 ; // the falling ball
    private int xSpeed = 0;  // speed of ball
    private int ySpeed = 0;
    private JLabel speedLabel;       // label showing speed
    
    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    
    public SnakeController() {
        startController(1500, 1500);
    }
    // construct and add GUI items
    public void begin() {
        snakeBall1 = new SnakeBall(xSpeed, ySpeed, new Location(100,100), canvas );
        snakeBall2 = new SnakeBall(xSpeed, ySpeed, new Location(80, 100),canvas );
        redBall3 = new RedBall(canvas );
        canvas.addKeyListener ( this );
        this.addKeyListener ( this );
        requestFocusInWindow();
    }
    
    // make a new ball when the player clicks
    public void onMouseClick( Location point ) {
        
    }
    
    // Required by KeyListener Interface but not used here.
    public void keyTyped( KeyEvent e ) { }

    // Required by KeyListener Interface but not used here.
    public void keyReleased( KeyEvent e ) { }

    // Change speed with up and down arrow keys
    public void keyPressed( KeyEvent e )
    {
        int key = e.getKeyCode();
        if ( key == KeyEvent.VK_LEFT && (!rightDirection)) {
            leftDirection = true;
            upDirection = false;
            downDirection = false;
            snakeBall1.setSpeed(-8, 0);
            snakeBall2.setSpeed(-8, 0);
        }
        else if ( key == KeyEvent.VK_RIGHT && (!leftDirection)) {
            rightDirection = true;
            upDirection = false;
            downDirection = false;
            snakeBall1.setSpeed(8, 0);
            snakeBall2.setSpeed(8, 0);;
        }
        else if ( key == KeyEvent.VK_DOWN && (!upDirection)) {
            downDirection = true;
            rightDirection = false;
            leftDirection = false;
            snakeBall1.setSpeed(0, 10);
            snakeBall2.setSpeed(0, 10);
        }
        else if ( key == KeyEvent.VK_UP && (!downDirection)) {
            upDirection = true;
            rightDirection = false;
            leftDirection = false;
            snakeBall1.setSpeed(0, -10);
            snakeBall2.setSpeed(0, -10);
        }
    }       
}