
/**
 * Write a description of class LoopTester here.
 * 
 * @author just add your names here
 * @version (a version number or a date)
 */

import java.awt.*;
import java.util.Scanner;


public class LoopTester{
    
    private Scanner in = new Scanner(System.in);
    private int sum, i, j, z, x, counter;
    private double b;
public void addNumbers (){
      // user enters 5, 7, 8
    sum = 0;

    for ( i=0;  i<3; i=i+1 ) {
         System.out.println(" Next value, please? ");
         x = in.nextInt();
         sum = sum + x;     
    }                      
    System.out.println("Sum = "+sum); 
}
public void multNumbers(){
    counter = 0;
        for (z=0; z<10; z=z+1){
      for (j=0; j<10; j=j+2){
         System.out.println(z*j);
         counter++;
        }
        }
        System.out.println(counter);
        /* The numbers of each multiplication section increase by 2
         * for integer "j" and its loops
         * then by 4
         * then by 6
         * then by 8
         * and so on...
         * 
         * for the integer "z" however, the numbers increase by 1
         * and follow a similar pattern as described before
         */
        
        
    }
public void bankCounter(){
    
    double checkAmt, bankBalance = 500.00 ;
    System.out.println("You're balance is $" + bankBalance );
   
    do {
         System.out.println("Check Amt? ");

	// user enters positive values representing checkcard purchases
         checkAmt = in.nextDouble(); 
         System.out.println(" -  $" + checkAmt);
         bankBalance = bankBalance - checkAmt;
    } while ( bankBalance > 0 );

    System.out.println("You are overdrawn by $" + ( - bankBalance ) );
    /* for every number that is entered in by the user, an amount is subtracted
     * that is, whatever is submitted to the scanner is subtracted from the bankBlance integer
     * if an amount that is too large for the original bankBalance is submitted,
     * the user will receive the message "you are overdrawn by $..."
     */
}
public void lessThanHundred(){
    b = 10.0;
while (x < 100.0) {
   System.out.println("" + x + "is less than 100");
   b = b * .5;
}
/* this is a perfect example of poorly written code
 * essentially, this code keeps printing the line that a particular number is less than one hundred,
 * so long as the number is less than a hundred
 * Since there are no mutators and changes in this initially given value,
 * the line just keeps printing...forever.
 */
}
}