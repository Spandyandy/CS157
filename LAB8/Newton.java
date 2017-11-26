import java.util.Scanner;
public class Newton{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter a number. ");
        double n = in.nextDouble();
        double oldApprox = 1.0;
        double newApprox = n;
        
       do{
            oldApprox = newApprox;
            newApprox = (oldApprox + n/oldApprox)/2;
        }while (newApprox - oldApprox >= 0.001||oldApprox - newApprox >= 0.001);
        System.out.println("The square root of your entered value is: " + newApprox);
    }
}