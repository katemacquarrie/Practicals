import java.math.BigInteger;
import java.util.Scanner;
import java.util.function.BiFunction;

/**
 * This class finds the largest integer K such that:
 * 
 *     f(K) = sum(j * floor(K/j)) for j = 1 to (K-1)  is ≤ N
 * 
 * and uses binary search to  determine the maximum possible K for a given large integer N.
 * This program handles large values using BigInteger for precision.
 */
public class Pricing {

    public BigInteger getfK(int K) {
        BigInteger val = BigInteger.ZERO;
        for (int j = 1; j<K; j++) {
            val = val.add(BigInteger.valueOf(j*(K/j)));
        }
        return val;
    }

    /*public BigInteger getSqrt(BigInteger N) {
        return (N.add(N)).sqrt();
    }*/

    public int sumTo(BigInteger N) {
        return (N.add(N.add(BigInteger.ONE))).sqrt().intValue();
    }

    public int findK(BigInteger N, int lo, int hi) {
        int check = (hi+lo)/2;

        //System.out.println("lo "+lo);
        //System.out.println("hi "+hi);
        //System.out.println("check "+check);
        //System.out.println("f(check) "+getfK(check));
        //System.out.println("f(check+1) "+ getfK(check+1));
        //System.out.println("N "+N);
        //System.out.println("getfK(check).compareTo(N) "+getfK(check).compareTo(N));

        if (getfK(check).compareTo(N) <= 0) {
            if (getfK(check+1).compareTo(N)==1) {
                //System.out.println("in loop 1");
                return check;
            } else {
                //System.out.println("in loop 2");
                return findK(N, lo, check);
            }
        } else {
            //System.out.println("in loop 3");
            return findK(N, check, hi);
        }
    }

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger N = scanner.nextBigInteger();

        scanner.close();

        Pricing pricing = new Pricing();

        int lo = pricing.sumTo(N)-1;
        int hi = N.sqrt().intValue()+2;

        //System.out.println("lo "+lo);
        //System.out.println("hi "+hi);


        int K = pricing.findK(N, lo, hi);
        System.out.println(K);


       }
}
