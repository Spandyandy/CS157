
/**
 * Write a description of class ClockWindow here.
 * 
 * @author (Reese and Andy) 
 * @version (2/18/16)
 */
import objectdraw.*;
import java.awt.*;
import java.util.Scanner;
public class ClockWindow extends WindowController
{
    public ClockWindow(){
            startController(1024, 768);
        }
    private ClockDisplay visualClock;
    private Text showClock;
    private Text showAlarm;
    private Button hourInc;
    private Button minInc; 
    private int h,m, alh,alm;
    private Button entTime;
    private Scanner input;
    private ClockDisplay alarmClock;
    private Button alarm;
    private Button snooze;
    private boolean alarmTF;
    private Text beep;
    private long totalSeconds = System.currentTimeMillis()/1000;
    public static void main(String[] args){
        new ClockWindow();
    }
 public void begin () 
 {  
     h=4;
     m=20;
     alh=0;
     alm=0;
     visualClock = new ClockDisplay();
     visualClock.setTime(h,m);
     alarmClock = new ClockDisplay();
     alarmClock.setTime(alh,alm);
     showClock = new Text("" + visualClock.getTime(), 20 , 20 , canvas);
     showClock.setFontSize(48);
     showAlarm = new Text("" + alarmClock.getTime(),20, 20,  canvas);
     showAlarm.setFontSize(48);
     showAlarm.hide();
     alarmTF= false;
     hourInc = new Button ("Hour", 180, 30,'a', canvas);
     minInc = new Button ("Minute", 180, 50,'b', canvas);
     entTime = new Button ("enter time", 20,140, 'c',canvas);
     alarm = new Button("set alarm", 180, 80, 'd' , canvas);
     snooze = new Button("snooze", 20, 180, 'e', canvas);
     input = new Scanner (System.in);
     beep = new Text("BEEEEEEEEEEEEEEEEEEEEEEEP", 50,250,canvas);
     beep.setFontSize(30);
     beep.hide();         
    }
 public void onMouseClick(Location point){
    if (hourInc.contains(point)&& alarmTF ==true){
        alh = alh+1;
        if(alh==h && alm==m){
         beep.show();
         }
        alarmClock.setTime(alh,alm);
        showAlarm.setText(""+alarmClock.getTime());
    }
    if (minInc.contains(point)&& alarmTF==true){
        alm = alm + 1;
        if(alh==h && alm==m){
         beep.show();
         }
        alarmClock.setTime(alh,alm);
        showAlarm.setText(""+alarmClock.getTime());
    }
    if (hourInc.contains(point)&&alarmTF == false){
        h = h+1;
        if(alh==h && alm==m){
         beep.show();
         }
        visualClock.setTime(h,m);
        showClock.setText(""+visualClock.getTime());
    }
    if (minInc.contains(point)&& alarmTF== false){
        m = m + 1;
        if(alh==h && alm==m){
         beep.show();
         }
        visualClock.setTime(h,m);
        showClock.setText(""+visualClock.getTime());
    }
    if (entTime.contains(point)){
         System.out.println ("Enter the time. First the hour: ");
         h = input.nextInt();
         
         
         System.out.println ("Now, the minute: ");
        m = input.nextInt();
        visualClock.setTime(h,m);
        showClock.setText(""+visualClock.getTime());
        
         
     }
     if ( alarm.contains(point)){
         if(alarmTF == true){
             showAlarm.hide();
             alarm.setColor(0, 0, 0);
            showClock.show();
            alarmTF = false;

        }
        else if (alarmTF == false){
            showAlarm.show();
            showClock.hide();
            alarm.setColor(253, 0, 0);
           alarmTF =true;
        }
    }
    if (snooze.contains(point)){
        beep.hide();
    }
    }
}
 