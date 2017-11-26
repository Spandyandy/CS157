/**
 * Class RadarController generates test data for RadarStats and tests the new methods.
 * 
 * Andy Kim Junghoo
 * 
 * RadarController part3
 */

import objectdraw.*;
import java.awt.*;

public class RadarController extends WindowController {

    private RadarStats stats;
    private int max, min, whenMin;
    private RandomIntGenerator speed = new RandomIntGenerator( 50, 65 );
    private RandomIntGenerator hour = new RandomIntGenerator( 0, 23 );
    
    public static void main(String[] s) { 
	new RadarController().startController(600,600); 
    }

    public void begin() {
        stats = new RadarStats( 55, canvas );
        for ( int count = 0; count < 250; count++ ) {
            stats.vehicleReport( (double)speed.nextValue(), hour.nextValue(), 15);
        }
        System.out.println(stats.minSpeeders() + "       " + stats.minSpeederHour());
    }
    
    public void onMouseClick( Location point ) {
        // test your stats reports/graphs here
        //stats.drawHistogram();
        //stats.drawLineGraph();
        //stats.Report();
    }
    
    public void onMouseExit( Location point ) {
    }
}