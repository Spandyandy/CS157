import objectdraw.*;
public class LightenUp extends WindowController{
    private LightenSky sun;
    
    public LightenUp(){
        startController(600, 600);
    }
    
    public void begin(){
        sun = new LightenSky(100, canvas);
    }
    
    public void onMouseExit(Location point){
        sun.stopRising();
    }
}