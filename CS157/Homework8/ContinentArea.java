public class ContinentArea{
    public static void main(String[] args){
        double [] continentalArea = {20.3, 8.9, 30.0, 5.2, 6.7, 16.3, 8.9};
        String [] continentName = {"Africa", "Antarctica", "Asia", "Australia", 
                                        "Europe", "North America", "South America"};
        double TOTAL_AREA = 57000000;              
        Continent continent;
        
        for (int i=0; i<7; i++){
            //System.out.println(continentName[i] + "  " + continentalArea[i] * TOTAL_AREA / 100);      //for part a,b
            continent = new Continent(continentName[i], continentalArea[i]);                            //for part c
            System.out.println(continent.getName() + "  " + continent.getArea() * TOTAL_AREA / 100);    //for part d
        }
    }
}
    