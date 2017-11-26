/**
 * 
 * Andy Kim ( Junghoo)
 * Feb 21, 2016
 * 
 */
import objectdraw.*;
public class Time extends WindowController {
        
        private long totalMilliSeconds=System.currentTimeMillis();
        private long totalSeconds=totalMilliSeconds/1000;
        private long totalMinutes=totalSeconds/60;
        private long minute=(totalMinutes%60);
        private long totalHours=totalMinutes/60;
        private long hour=(24-totalHours%24); // in military time
public void begin() {
System.out.println("The time is now " + minute + " minutes after "+ hour + ".");
}
}