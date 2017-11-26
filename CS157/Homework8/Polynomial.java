public class Polynomial{
    private double [] coef ;
    
    public Polynomial( int degree ){
        coef = new double [degree+1];
    }
    
    public void setCoef( double value, int i){
        if (i >= 0 && i < coef.length){
            coef[i] = value;
        }
    }
    
    public double eval(double x){
        double result = 0;
        double power = 1;
        
        for (int i = 1; i <= coef.length; i++){
            result = result + power * coef[i-1];
            power = power * x;
        }
        return result;
    }
}
    