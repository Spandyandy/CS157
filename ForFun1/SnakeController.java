import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Control speed of falling ball with up and down arrow keys
public class SnakeController extends WindowController implements KeyListener {
    
    private static final int SLOW_SPEED = 1,
                             FAST_SPEED = 10;  // initial speed
    
    private SnakeBall snakeBall1, snakeBall2,snakeBall3 ; // the falling ball
    private int xSpeed = 1;  // speed of ball
    private int ySpeed = 1;
    private JLabel speedLabel;       // label showing speed
    
    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    
    public SnakeController() {
        startController(400, 600);
    }
    // construct and add GUI items
    public void begin() {
        snakeBall1 = new SnakeBall(xSpeed, ySpeed, canvas );
        snakeBall2 = new SnakeBall(xSpeed, ySpeed, canvas );
        snakeBall3 = new SnakeBall(xSpeed, ySpeed, canvas );
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
            snakeBall1.setSpeed(-2, 0);
            snakeBall2.move(snakeBall1.getXLoc()-20,snakeBall1.getYLoc()-20);
        }
        else if ( key == KeyEvent.VK_RIGHT && (!leftDirection)) {
            rightDirection = true;
            upDirection = false;
            downDirection = false;
            snakeBall1.setSpeed(2, 0);
            snakeBall2.move(snakeBall1.getXLoc()-20,snakeBall1.getYLoc()-20);
        }
        else if ( key == KeyEvent.VK_DOWN && (!upDirection)) {
            downDirection = true;
            rightDirection = false;
            leftDirection = false;
            snakeBall1.setSpeed(0, 2);
        }
        else if ( key == KeyEvent.VK_UP && (!downDirection)) {
            upDirection = true;
            rightDirection = false;
            leftDirection = false;
            snakeBall1.setSpeed(0, -2);
        }
    }       
}