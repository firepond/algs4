package fundamentals.analysisofalgorithms;

import java.util.Random;
import java.util.Arrays;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author firepond algs4 exercise 1.4.16
 */

public class Exercise16 {

    public static void main(String[] args) {
        int N = 20;
        double[] a = new double[N];
        Random r = new Random();
        for (int i = 0; i < N; i++) {
            a[i] = r.nextDouble();
            StdOut.print(a[i] + "  ");
        }
        StdOut.println();
        int[] res = closestPair(a);
        StdOut.println("Closest pair:");
        StdOut.println(res[0] + ": " + a[res[0]]);
        StdOut.println(res[1] + ": " + a[res[1]]);
    }

    public static int[] closestPair(double[] a) {
        int[] closestPair = new int[2];

        double currentMinimumDifference = Double.MAX_VALUE;

        Arrays.sort(a);

        for (int i = 0; i < a.length - 1; i++) {
            double curDifference = Math.abs(a[i] - a[i + 1]);
            if (curDifference < currentMinimumDifference) {
                currentMinimumDifference = curDifference;
                closestPair[0] = i;
                closestPair[1] = i + 1;
            }

        }
        return closestPair;
    }
}
