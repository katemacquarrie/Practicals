/**
 * This class omputes the farthest distance a cyclist can travel based on signpost values using a greedy algorithm
 * Reads N signposts with movement values and uses a greedy approach to track the max distance reached.  
 * Input: N (number of signposts) followed by N integers.  
 * Output: Maximum reachable distance.  
 */

import java.util.Scanner;

public class Cycling {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] signs = new int[N];

        for (int i = 0; i < N; i++) {
            signs[i] = scanner.nextInt();
        }

        scanner.close();

        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < N; i++) {
            //System.out.println("at Si: "+signs[i]);
            //System.out.println("farthest "+farthest);
            //System.out.println("currentend "+currentEnd);
            currentEnd = Math.max(0, currentEnd+signs[i]);
            farthest = Math.max(farthest, currentEnd);

        }

        System.out.println(farthest);
    }

}
