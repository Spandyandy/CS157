public class Continent{
    private String name;
    private double area;
    
    public Continent( String aName, double theArea){
        name = aName;
        area = theArea;
    }
    
    public String getName(){
        return name;
    }
    
    public double getArea(){
        return area;
    }
}