
/**
 * 
 * 
 * 
 * 
 * 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import objectdraw.*;

public class RisingSun extends WindowController
{

   private Text message;
   private RSun sun;
   
   public RisingSun() {
       startController();
    }
   
   public void begin() {
       message = new Text("Click to watch the sun rise", 0, 0, canvas);
    }
    
    public void onMouseEnter(Location point) {
        message.hide();
    }
    
    public void onMouseClick(Location point) {
       sun = new RSun(canvas);
    }
    
    public void onMouseExit(Location point) {
        message.show();
        sun = new RSun(canvas);
    }
}
