package fundmentals.programmingmodel;

/**
 * @author firepond
 * algs4 exercise 1.1.35
 */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise35 {

    public static void main(String[] args) {
        double[] precision = precisionPossibility();
        int times = 10000000;
        double[] experiment = experimentalPossibility(times);
        for (int i = 2; i <= 12; i++) {
            StdOut.printf("%.3f  ", precision[i]);
        }
        StdOut.println();
        for (int i = 2; i <= 12; i++) {
            StdOut.printf("%.3f  ", experiment[i]);
        }
        StdOut.println();
        for (int i = 2; i <= 12; i++) {
            StdOut.printf("%.5f ", experiment[i] - precision[i]);
        }
    }

    public static double[] precisionPossibility() {
        int SIDES = 6;
        double[] dist = new double[2 * SIDES + 1];
        for (int i = 1; i <= SIDES; i++) {
            for (int j = 1; j <= SIDES; j++) {
                dist[i + j] += 1.0;
            }
        }

        for (int k = 2; k <= 2 * SIDES; k++) {
            dist[k] /= 36.0;
        }

        return dist;
    }

    public static double[] experimentalPossibility(int times) {
        int[] frequency = new int[13];
        int count = 0;
        while (count++ < times) {
            int a = StdRandom.uniform(1, 7);
            int b = StdRandom.uniform(1, 7);
            frequency[a + b]++;
        }

        double[] dist = new double[13];
        for (int k = 2; k <= 12; k++) {
            dist[k] = (double) frequency[k] / times;
        }

        return dist;
    }
}
