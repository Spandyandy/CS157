package RisingSun;


/**
 * Write a description of class RisingSun here.
 * 
 * @author Junghoo Kim
 * @version 1/14/16
 */
import objectdraw.*;
    import java.awt.*;
public class RisingSun extends WindowController
{
    private Text instructions;
    private FilledOval sun;
    public RisingSun()
    {
        startController(200, 200);
    }
    public void begin() {
        sun = new FilledOval( 100, 100, 100, 100, canvas);
        sun.setColor(Color.green);
        instructions= new Text("Please click the mouse repeatedly",20, 20, canvas );
    }
    public void onMouseClick(Location point)
    {
        sun.move( 0, -5);
        instructions.hide();
    }
    public void onMouseExit(Location point)
    {
        sun.moveTo(50,150);
        instructions.show();
    }
}
