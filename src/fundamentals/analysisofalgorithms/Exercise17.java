package fundamentals.analysisofalgorithms;

import java.util.Random;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author firepond algs4 exercise 1.4.17
 */

public class Exercise17 {

    public static void main(String[] args) {
        int N = 20;
        double[] a = new double[N];
        Random r = new Random();
        for (int i = 0; i < N; i++) {
            a[i] = r.nextDouble();
            StdOut.print(a[i] + "  ");
        }
        StdOut.println();
        int[] res = farestPair(a);
        StdOut.println("Farest pair:");
        StdOut.println(res[0] + ": " + a[res[0]]);
        StdOut.println(res[1] + ": " + a[res[1]]);
    }

    public static int[] farestPair(double[] a) {
        int min = 0;
        int max = 0;
        int N = a.length;
        for (int i = 1; i < N; i++) {
            if (a[i] < a[min]) {
                min = i;
            }
            if (a[i] > a[max]) {
                max = i;
            }
        }
        return new int[] { min, max };
    }
}
