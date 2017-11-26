public class PolynomialTest{
    public static void main(String[] args){
        
        Polynomial sample1 = new Polynomial(3);
        Polynomial sample2 = new Polynomial(5);
        Polynomial sample3 = new Polynomial(4);
        
        //first construction 
        sample1.setCoef(2, 0);
        sample1.setCoef(4, 1);
        sample1.setCoef(1.5, 2);
        sample1.setCoef(3, 3);
        System.out.println(sample1.eval(-2)); //first call   expected: -24.0   Result: -24.0
        System.out.println(sample1.eval(0)); //second call   expected: 2.0     Result: 2.0
        System.out.println(sample1.eval(2)); //third call    expected: 40.0    Result: 40.0
        
        System.out.println("\n\n\n");
         
        //second construction
        sample2.setCoef(5, 0);
        sample2.setCoef(2, 1);
        sample2.setCoef(2.5, 2);
        sample2.setCoef(1, 3);
        sample2.setCoef(0, 4);
        System.out.println(sample2.eval(-3)); //first call   expected: -5.5    Result: -5.5
        System.out.println(sample2.eval(0)); //second call   expected: 5.0     Result: 5.0
        System.out.println(sample2.eval(1)); //third call    expected: 10.5    Result: 10.5
        
        System.out.println("\n\n\n");
        
        //third construction
        sample3.setCoef(1, 0);
        sample3.setCoef(5, 1);
        sample3.setCoef(2, 2);
        sample3.setCoef(3.5, 3);
        System.out.println(sample3.eval(-2)); //first call   expected: -29.0    Result: -29.0
        System.out.println(sample3.eval(0)); //second call   expected: 1.0      Result: 1.0
        System.out.println(sample3.eval(3)); //third call    expected: 128.5    Result: 128.5
        
    }
}