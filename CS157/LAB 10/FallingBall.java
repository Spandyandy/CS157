import objectdraw.*;
import java.awt.*;

// Animate a falling ball
public class FallingBall extends ActiveObject {
    
    private static final int BALLSIZE = 15;
    private static final int DELAY_TIME = 33;
    
    private DrawingCanvas canvas; // canvas to draw on
    private FilledOval ball;      // Image of ball as circle
    private int speed;            // current speed of ball
    
    // Draw ball at location and w/speed given in parameters
    public FallingBall( Location ballLocation, int initSpeed, 
                        DrawingCanvas aCanvas ) {
        canvas = aCanvas;
        ball = new FilledOval( ballLocation, BALLSIZE, BALLSIZE, canvas );
        speed = initSpeed;
        start();
    }
    
    // Move ball down until off of canvas
    public void run() {
        while ( ball.getY() < canvas.getHeight() ) {
            ball.move( 0, speed );
            pause( DELAY_TIME );
        }
        ball.removeFromCanvas();
    }
    
    // reset speed of ball
    public void setSpeed( int newSpeed ) {
        speed = newSpeed;
    }
}