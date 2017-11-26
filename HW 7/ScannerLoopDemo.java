import java.util.Scanner;

public class ScannerLoopDemo {

  public static void main (String[] args) {

    Scanner in = new Scanner(System.in);

    int maxValue = -1;
    boolean goodInput = false; 

    System.out.println("\n\tWelcome to the Modulus 7 Demo Program");
    System.out.println("\n\t-------------------------------------");
 
    do{ 
      System.out.print("\n\tEnter a non-negative integer:  ");
      maxValue = in.nextInt();
      
      if (maxValue >= 0)
          goodInput = true;  
    }while ( !goodInput ); 

    int y = 7;
    for (int x=0; x <= maxValue; x++) {  
      System.out.printf("\n\t\t%2d %% %2d ==> %2d",  x, y, x % y );
    }
    System.out.println("\n");
  }
}