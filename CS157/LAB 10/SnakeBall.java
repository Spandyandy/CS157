import objectdraw.*;
import java.awt.*;

// Animate a falling ball
public class SnakeBall extends ActiveObject {
    
    private static final int BALLSIZE = 20;
    private static final int DELAY_TIME = 50;
    
    private DrawingCanvas canvas; // canvas to draw on
    private FilledOval ball;      // Image of ball as circle
    private int xSpeed, ySpeed;            // current speed of ball
    
    // Draw ball at location and w/speed given in parameters
    public SnakeBall(int initXSpeed, int initYSpeed, Location loc,
                        DrawingCanvas aCanvas ) {
        canvas = aCanvas;
        ball = new FilledOval( loc, BALLSIZE, BALLSIZE, canvas );
        xSpeed = initXSpeed;
        ySpeed = initYSpeed;
        start();
    }
    
    // Move ball down until off of canvas
    public void run() {
        while ( ball.getY() < canvas.getHeight() && ball.getX() < canvas.getWidth()) {
            ball.move( xSpeed, ySpeed );
            pause( DELAY_TIME );
        }
        ball.removeFromCanvas();
    }
    
    // reset speed of ball
    public void setSpeed( int newXSpeed, int newYSpeed ) {
        xSpeed = newXSpeed;
        ySpeed = newYSpeed;
    }
    public int getXLoc(){
        return (int)ball.getX();
    }
    public int getYLoc(){
        return (int)ball.getY();
    }
    public void move(int x, int y){
        ball.move(x,y);
    }
}