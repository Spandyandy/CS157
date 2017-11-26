
/**
 * Write a description of class Button here.
 * 
 * Andy and Daniel
 * 2.11.16
 */
import java.awt.*;
import objectdraw.*;
public class Button {
    private Text instructions;
    private Location location;
    private DrawingCanvas canvas;
    private FramedRoundedRect rect;
    private int value;
    private double width;
    private double height;
    
    
    public Button(String text, int x, int y, int value, DrawingCanvas canvas){
        instructions = new Text(text,  x, y, canvas);
        width = instructions.getWidth();
        height = instructions.getHeight();
        rect = new FramedRoundedRect (x, y, width , height, 10, 10, canvas);
    }
    public void setColor(int r, int g, int b){
        rect.setColor(new Color(r, g, b));
        instructions.setColor(new Color(r, g, b));
    }
    public void setSize(int width, int height){
        rect.setSize(width, height);
        instructions.setFontSize(height-5);
    }
    public void setText(String t){
        instructions.setText(t);
    }
    public void setFontSize(int size){
        instructions.setFontSize(size);
    }
    public boolean contains (Location point) {
        if ( rect.contains(point)){
            return true;
        }
        else {
            return false;
        }
    }
    public int value(){
        return value;
    }
}