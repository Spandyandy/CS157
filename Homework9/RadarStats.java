/**
 * Class RadarStats - maintains 24-hour traffic statistics for automated radar installation
 * 
 * Andy Kim Junghoo
 * Part 3
 */

import objectdraw.*;
import java.awt.*;

public class RadarStats {

    private int graphHeight = 3000;
    private int graphLeft = 10;
    private int graphBottom = 450;
    private int barWidth = 20;
    //DISPLAY
    
    private double speedlimit;
    private int[] speedersAt = new int[24];
    private double[] driversAt = new double[24];
    private double[] speedingFraction = new double[24];
    
    private DrawingCanvas canvas;

    public RadarStats(double speedlim, DrawingCanvas dc){
        speedlimit = speedlim;
        canvas = dc;
    }

    public void vehicleReport(double speed, int hour, int min) {            //14.5.1
        driversAt[hour]++;
        if(speed>speedlimit) {
             speedersAt[hour]++;
        }
        speedingFraction[hour] = speedersAt[hour]/driversAt[hour];
    }
    
    public int minSpeeders() {               //14.5.2.a
        int min = speedersAt[0];
        for(int hour=1; hour< speedersAt.length; hour++){
            if (speedersAt[hour]<min){
                min = speedersAt[hour];
            }
        }
        return min;
    }
    
    public int minSpeederHour(){
        int min = speedersAt[0];
        int minHour = 1;
        for(int hour=1; hour< speedersAt.length; hour++){
            if (speedersAt[hour]<min){
                min = speedersAt[hour];
                minHour = hour;
            }
        }
        return minHour;
    }
    
    public int speedersSeen() {
        int total = 0;
        for (int hour = 0; hour < speedersAt.length; hour++) {
            total = total + speedersAt[hour];
        }
        return total;
    }
    
    
    public int maxSpeeders() {
        int max = speedersAt[0];
        for (int hour = 1; hour <speedersAt.length; hour++) {
            if (speedersAt[hour] > max) {
                max = speedersAt[hour];
            }
        }
        return max;
    }
    
    public void drawHistogram() {
        double barHeight;
        double totalSpeeders = speedersSeen();
        
        for (int hour = 0; hour < speedersAt.length; hour++) {
            barHeight = (speedersAt[hour]/totalSpeeders)*graphHeight;

            new FilledRect(graphLeft+hour*barWidth, 
                           graphBottom-barHeight,
               barWidth-1, 
               barHeight,
               canvas);
        }
    }
    
    public void drawLineGraph(){
        new Line (graphLeft, graphLeft, graphLeft, graphBottom, canvas);
        new Line (graphLeft, graphBottom, graphBottom+barWidth, graphBottom, canvas);
        double height1, height2;
        double totalSpeeders = speedersSeen();
        for (int hour = 0; hour < speedersAt.length-1; hour++) {
            height1 = (speedersAt[hour]/totalSpeeders)*graphHeight;
            height2 = (speedersAt[hour+1]/totalSpeeders)*graphHeight;
            new Line(graphLeft+hour*barWidth, graphBottom-height1, 
                        graphLeft+(hour+1)*barWidth, graphBottom-height2, canvas);
        }
    }
}  // end Radar Stats