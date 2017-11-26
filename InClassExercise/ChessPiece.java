
/**
 * Abstract class ChessPiece - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
import java.awt.*;
import objectdraw.*;
public abstract class ChessPiece
{
    protected Color color;
    protected int pointValue;
    protected String position;
    protected Image image;
    protected boolean captured =false;
    
    
    public abstract void move(String position);
    
    public void captured(){
        captured = true;
    }
    
    public abstract void draw(String position);
    
    public int getValue(){ return pointValue;}
}
