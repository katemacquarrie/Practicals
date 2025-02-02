import java.math.BigInteger;
import java.util.Scanner;

// A class to find the largest left-truncatable prime number that is smaller than or equal to a given input number
public class Truncate {

    public boolean isTruncPrime(BigInteger number, int numlength) {

        if (numlength == 0) {
            return true;
        }

        else if (number.isProbablePrime(1)) {
            return isTruncPrime(number.mod((BigInteger.TEN).pow(numlength -1)), numlength-1);
            }
        
        else {return false;}
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String numstring = scanner.next();

        scanner.close();

        int numlength = numstring.length();
        int numint = Integer.parseInt(numstring);
        BigInteger number = new BigInteger(numstring);

        Truncate truncate = new Truncate();

        while (!(truncate.isTruncPrime(number, numlength))||((number.toString()).contains("0"))) {
            number = number.add((BigInteger.ONE).negate());
        }

        System.out.print(number.toString());

    }
}
