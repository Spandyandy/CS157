import objectdraw.*;
import java.util.Scanner;
public class JK extends WindowController {
    public JK(){
        startController(200,200);
    }
    private int h,w;
    public void begin() {
       for (h=canvas.getHeight()/2, w=canvas.getWidth()/4; w > 10 && h > 20; w-=10, h-=10) {
 
      int w2 = w * 2;
     
      if (h > canvas.getHeight()) {

        System.out.println("h is too high: " + h);

      } else {

        new Line(w, h, w2, h, canvas);

        h = h + w2;

      }
 }
}
}