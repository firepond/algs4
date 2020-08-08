package elementarysorts;

import edu.princeton.cs.algs4.*;

public class SortCompare {
    public static double time(String alg, Double[] a) {
        Stopwatch timer = new Stopwatch();

        switch (alg) {
            case "Bubble":
                Bubble.sort(a);
                break;
            case "Insertion":
                Insertion.sort(a);
                break;
            case "Selection":
                Selection.sort(a);
                break;
            case "Shell":
                Shell.sort(a);
                break;
        }

        return timer.elapsedTime();

    }

    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++) {
                a[i] = StdRandom.uniform();
            }
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String[] args) {
        String alg2 = "Insertion";
        String alg1 = "Bubble";
        int N = 10000;
        int T = 10;
        double t1 = timeRandomInput(alg1, N, T);
        double t2 = timeRandomInput(alg2, N, T);
        StdOut.printf("For %d random Doubles\n    %s is", N, alg1);
        StdOut.printf(" %.1f times faster than %s\n", t2 / t1, alg2);

    }
}