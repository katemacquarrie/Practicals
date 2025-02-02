import java.util.Scanner;

// This class solves for x in the eqn 1+2(3^x)+7^x=N given int N using a binary search approach
public class Spill {

    public String findX(double N, String n_string, double lo, double hi) {
        
        double check = (hi+lo)/2;
        //System.out.print(check);

        double check_pow = 1 + 2*(Math.pow(3, check)) + Math.pow(7, check);
        String pow_string = String.format("%.9f", check_pow);
        
        if (pow_string.compareTo(n_string)==0) {
            return String.format("%.9f", check);
        } else {
            if (check_pow > N) {
                //System.out.println("in loop 2");
                return findX(N, n_string, lo, check);
            } else {
                //System.out.println("in loop 1");
                return findX(N, n_string, check, hi);
            }
        }

    }

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        double N = scanner.nextDouble();
        scanner.close();

        String n_string = String.format("%.9f", N);

        double lo = Math.log10(N/2);
        //System.out.println("lo "+lo);

        double hi = Math.log(N/4);
        //System.out.println("hi "+hi);

        Spill spill = new Spill();
        System.out.println(spill.findX(N, n_string, lo, hi));
            
        

    }

}
