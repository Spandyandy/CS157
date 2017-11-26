/**
 * WeatherData - models one month's worth of temperature/rainfall data
 * Simplifying assumption: month has 31 days
 * Better model uses Date class to remove this assumption
 * 
 * @author spc
 * @version 1.0
 */

public class WeatherData {
    // parallel arrays for a month's worth of weather data
    
    private static final int DAYS = 31;
    
    private int[] hiTemps = new int [DAYS];
    private int[] loTemps = new int [DAYS];
    private double[] rainfall = new double [DAYS];
    private String[] conditions = new String [DAYS];

    // constructor
    public WeatherData() {
    }

    /* todaysWeather - enter the weather conditions for day into arrays
       @pre:  day > 0 && day <= 31
       @post: weather conditions entered into arrays
    */
    public void todaysWeather(int day, int hi, int low, double rain, String cond) {
        // turn day into a valid index
        day--;
        hiTemps[day] = hi;
        loTemps[day] = low;
        rainfall[day] = rain;
        conditions[day] = cond;
    }
    
    
    
    /* getRainfall - return the rainfall for day
       @pre: day > 0 && day <= 31
       @post: returns the total rainfall
    */
    public double getRainfall(int day) {
        return rainfall[day];
    }

    /* averageRainfall - computes average rainfall for the month
       @pre: none
       @post: returns the average rainfall
    */
    public double averageRainfall() {
        // first sum up all rainfall for month
        double sum = 0;
        for (int i = 0; i < rainfall.length; i++) {
            sum += rainfall[i];
        }
        // and divide by days in month to get average (assuming 31 days)
        return sum/rainfall.length;
    }

    /* printWeatherData - output weather information for given day
       @pre:  day > 0 && day <= 31
       @post: weather conditions printed
    */
    public void printWeatherData(int day) {
        day--;
        System.out.println("High temperature: "      + hiTemps[day]);
        System.out.println("Low temperature: "       + loTemps[day]);
        System.out.println("Total rainfall: "        + rainfall[day]);
        System.out.println("Prevailing weather conditions: " + conditions[day]);
    }
    
    /* getRainfall - return the rainfall for day
       @pre: day > 0 && day <= 31
       @post: returns the average temperature
    */
    public double averageDailyTemp(int day){
        double averageTemp = (hiTemps[day] + loTemps[day])/ 2;
        return averageTemp;
    }
    
    /* getRainfall - return the rainfall for day
       @pre: day > 0 && day <= 31
       @post: returns the average monthly temperature
    */
    public double averageMonthlyTemp(int day){
        double sum = 0;
        for (int i = 0; i < rainfall.length; i++) {
            sum += averageDailyTemp(i);
        }
        return sum/rainfall.length;
    }
    
}
    