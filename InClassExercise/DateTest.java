/**
 *  Andy Kim (Junghoo)
 */

public class DateTest
{
    public static void main(String[] args){
        try { 
            Date1 a = new Date1(4, 25, 2016);
            System.out.println(a);
            } catch (IllegalArgumentException ex) {
            System.out.println("Problem: " + ex);
        }catch (ArrayIndexOutOfBoundsException ex) { 
             System.out.println("Problem: " + ex);
        }
        try { 
            Date1 b = new Date1(1100, 1, 2500);
            System.out.println(b);
            } catch (IllegalArgumentException ex) {
            System.out.println("Problem: " + ex);
        }catch (ArrayIndexOutOfBoundsException ex) { 
             System.out.println("Problem: " + ex);
        }
        try { 
            Date1 c = new Date1(1, 1, -2016);
            System.out.println(c);
            } catch (IllegalArgumentException ex) {
            System.out.println("Problem: " + ex);
        }catch (ArrayIndexOutOfBoundsException ex) { 
             System.out.println("Problem: " + ex);
        }
        try { 
            Date1 d = new Date1(1, 13, 2016);
            System.out.println(d);
            } catch (IllegalArgumentException ex) {
            System.out.println("Problem: " + ex);
        }catch (ArrayIndexOutOfBoundsException ex) { 
             System.out.println("Problem: " + ex);
        }
    }
}
