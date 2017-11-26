import objectdraw.*;
import java.awt.*;
public class AlmostBullseye extends WindowController {
    public AlmostBullseye (){
        startController(500,500);
    }
    private int a;
    public void begin(){
        a=100;
        while(a >= 20){
            new FramedOval(10,10,a,a, canvas);
            a -= 20;
    }
}
}