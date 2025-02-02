import java.util.Scanner;

// This class uses binary search to find the maximum possible length M such that at least K pieces can be obtained from a plank
public class Dividing {

    public static boolean canCut(long[] lengths, long M, long K) {
        long count = 0;
        for (long length : lengths ) {
            count += length/M;
            if (count >= K) {return true;}
        }
        return count>=K;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();

        long[] lengths = new long[N];

        for (int i = 0; i < N; i++) {
            lengths[i] = scanner.nextLong();
        }

        long K = scanner.nextLong();
        scanner.close();

        long low = 0;
        long high = 0;

        for (long length : lengths) {
            if (length > high) {
                high = length;
            }
        }

        long result = 0;

        while (low <= high) {
            long mid = (low+high)/2;
            if (canCut(lengths, mid, K)) {
                result = mid;
                low = mid+1;
            } else {
                high = mid -1;
            }
        }

        System.out.println(result);
    }

}
