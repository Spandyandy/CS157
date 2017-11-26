public class logarithm{
        public static void main(String[] args){
            double counter =1.0;
            double ln = 0;
            double n = 1.6;
            int terms = 25;
            
            while (counter <= terms) {
                ln += Math.pow((-1),counter-1)*(1/counter)*Math.pow((n-1),counter);
                counter ++;
            }
            System.out.println(ln);
        }
    }