/**
 * 
 * 
 * Junghoo Kim (ANDY)
 * Feb.21.2016
 * 
 * 
 */
public class Quadratic {
 
 private double a; // x squared term coefficient
 private double b; // x term coefficient
 private double c; // constant coefficient
 private double x1;
 private double x2;
 public Quadratic(double A, double B, double C) {
 a = A;
 b = B;
 c = C;// add assignments to initialize fields
 }

 // evaluate
 // post: given any value of x, returns the
 // result of computing the equation
 public double evaluate(double x) {
 return a*x*x+b*x+c;// add code here
 }

 // quadraticFormula
 // pre: a != 0 && b*b >= 4*a*c
 // post: computes and displays the roots
 public void quadraticFormula() {
 x1 = (-b + Math.sqrt(b*b-(4*a*c)))/(2*a);// add code here
 x2 = (-b - Math.sqrt(b*b-(4*a*c)))/(2*a);
 System.out.println("x = " + x1 + " and "+x2);// use System.out.println to display the roots
 }
}