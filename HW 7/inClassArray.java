import java.util.Scanner;
public class inClassArray{
    public static void main(String[] args){
        final int hiTemps[]={};
        int cars[];
        Scanner in = new Scanner(System.in);
        for (int i =0; i <31; i++){
            System.out.println("Enter next high temperature: ");
            hiTemps[i] = in.nextInt();
        }
        for (int i = 0; i<10000; i++){
            //random  generator
            cars[] = new Vehicle(/*random*/);
        }
    }
}