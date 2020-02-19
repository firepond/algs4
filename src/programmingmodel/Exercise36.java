package programmingmodel;

/**
 * @author firepond
 * algs4 exercise 1.1.36
 */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise36 {

    public static void main(String[] args) {
        int M = 6;
        int N = 600000;

        double[] array = new double[M];
        int[][] frequencies = new int[M][M];

        for (int i = 0; i < N; i++) {
            init(array);
            shuffle(array);
            for (int j = 0; j < array.length; j++) {
                frequencies[(int) array[j]][j]++;
            }
        }

        print(frequencies);        
    }

    public static void shuffle(double[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int r = i + StdRandom.uniform(N - i);
            double temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public static void init(double[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
    }

    public static void print(int[][] x) {
        for (int i = 0; i < x.length; i++) {
            print(x[i]);
        }
        StdOut.println();
    }

    public static void print(int[] x) {
        for (int i = 0; i < x.length; i++) {
            StdOut.print(x[i] + "  ");
        }
        StdOut.println();
    }
}
