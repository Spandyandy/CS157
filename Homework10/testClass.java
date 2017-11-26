
public class testClass extends InvalidDateException{

public static void main(String[]args){
    	Date one=new Date(4,25,2016);
    	System.out.println(one);
    	try {
        	Date two = new Date(4, 100 ,2016);
        	System.out.println(two);
    	}catch(IllegalArgumentException ex){
        	System.out.println("Problem: " + ex);
    	}
    	try {
        	Date three = new Date(4, 25 , -2016);
        	System.out.println(three);
    	}
    	catch(IllegalArgumentException ex){
        	System.out.println("Problem: "+ex);
    	}
    	try{
        	Date four=new Date(13,25,2016);
        	System.out.println(four);
    	}
    	catch(IllegalArgumentException ex){
        	System.out.println("Problem: "+ex);
    	}
    	catch(ArrayIndexOutOfBoundsException ex){
        	System.out.println("Problem: "+ex);
    	}
	}
}
