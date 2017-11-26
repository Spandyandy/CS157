import objectdraw.*;
import java.awt.*;
public class Bullseye extends WindowController {
    public Bullseye (){
        startController(500,500);
    }
    private int a,b,c,d;
    private FilledOval rcircle, bcircle;
    public void begin(){
        a=120;
        b=100;
        c=10;
        d=20;
        while(a >= 20){
            
            rcircle =new FilledOval(c,c,a,a, canvas);
            
            bcircle =new FilledOval(d,d,b,b, canvas);
            bcircle.setColor(Color.RED);
            c += 20;
            d+= 20;
            a -= 40;
            b-= 40;
    }
}
    }