import objectdraw.*;
import java.awt.*;

// Animate a falling ball
public class RedBall extends ActiveObject {
    
    private static final int BALLSIZE = 20;
    private static final int DELAY_TIME = 25;
    
    private DrawingCanvas canvas; // canvas to draw on
    private FilledOval ball;      // Image of ball as circle
    private int xSpeed, ySpeed;            // current speed of ball
    private RandomIntGenerator randGen;
    // Draw ball at location and w/speed given in parameters
    public RedBall(DrawingCanvas aCanvas ) {
        canvas = aCanvas;
        ball = new FilledOval(300,500, BALLSIZE, BALLSIZE, canvas);
        
        start();
    }
    
    public void run() {
        if (ball.getY() < canvas.getHeight()-20 && ball.getX() < canvas.getWidth()-20){
            while ( ball.getY() < canvas.getHeight()-20 && ball.getX() < canvas.getWidth()-20) {
                ball.move(10, 2 );
                pause( DELAY_TIME );
            }
        }
        if( ball.getY() > canvas.getHeight()-30 || ball.getX()> canvas.getWidth()-30){
            while ( ball.getY() > 10) {
                ball.move( 0, -10 );
                pause( DELAY_TIME );
            }
        }
        if( ball.getY() < 20 || ball.getX()>canvas.getWidth()-30){
            while ( ball.getY() < canvas.getHeight()-100) {
                ball.move( -10, 10 );
                pause( DELAY_TIME );
            }
        }
        if( ball.getY() < canvas.getHeight()-30 || ball.getX()>canvas.getWidth()-30){
            while ( ball.getY() > 20) {
                ball.move( 1, -5 );
                pause( DELAY_TIME );
            }
        }
    }
}