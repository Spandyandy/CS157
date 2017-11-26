
/**
 * Write a description of class k here.
 * 
 * @author (Andy and Reese) 
 * @version (a version number or a date)
 */
public class DateTester
{
    public static void main(String[] args) {
        
        
        Date a = new Date(12, 25, 1997);
        Date b = new Date(3,17,1997);
        Date c = new Date(10, 23, 1996);
        Date d = new Date(2, 25, 2016);
        Date e = new Date(7,4,2004);
        Date f = new Date(11,5,1753);
        Date g = new Date(1,17, 2057);
        Date h = new Date(12,31,1999);
        boolean r1= a.isLeapYear();
        boolean r2= b.isLeapYear();
        System.out.println("Leap Year results for " + a.toString() + ": " + r1);
                System.out.println("Leap Year results for Reese's birthday : " + r2);
         int r3= c.daysInMonth();
         int r4 = d.daysInMonth();
         System.out.println ("Days in Month for Andy's birthday: " + r3);
         System.out.println ("Days in Month for " + d.toString() + ": " + r4);
         int r5 = e.julianDate();
         int r6 = f.julianDate();
         System.out.println ("Julian date for " + e.toString() + ": " + r5);         
         System.out.println ("Julian date for "  + f.toString() + ": " + r6);
         String r7 = g.toString();
         String r8 = h.toString();
         System.out.println ("Display date in string: " + r7);
         System.out.println ("Display date in string: " + r8);
    }
 
}