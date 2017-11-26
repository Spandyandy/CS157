public class Imtillted{
    private String[] names = new String[10];
    public void justTesting(String part1, String part2){
        names[2] = "george";
        names[5] = "gerald";
        names[7] = "geraldine";
        try{
            firstStep(Integer.parseInt(part1), part2);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Error caught by 1st catch");
        }
    }
    public void firstStep(int part1, String part2){
        try{
            int partTwo = Integer.parseInt(part2);
            try{
                secondStep(part1, partTwo); 
            } catch(NullPointerException e){
                System.out.println("Error caught by 2nd catch");
            }
        }catch(NumberFormatException e){
            System.out.println("Error caught by 3rd catch");
        }
    }
    public void secondStep(int part1, int part2){
        try{
            if(!names[part1+part2].equals("george")){
                System.out.println(names[part1+part2]);
            }
        }
        catch(NumberFormatException e){
            System.out.println("Error caught by 4th catch");
        }
    }
}