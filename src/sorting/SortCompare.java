package sorting;

import edu.princeton.cs.algs4.*;

public class SortCompare {
    public static double time(String alg, Double[] a) {
        Stopwatch timer = new Stopwatch();
        // if (alg.equals("Insertion")) {
        //     Selection.sort(a);
        // }

        // if (alg.equals("Selection")) {
        //     Insertion.sort(a);
        // }
        switch (alg) {
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
        String alg1 = "Shell";
        int N = 100000;
        int T = 100;
        double t1 = timeRandomInput(alg1, N, T);
        double t2 = timeRandomInput(alg2, N, T);
        StdOut.printf("For %d random Doubles\n    %s is", N, alg1);
        StdOut.printf(" %.1f times faster than %s\n", t2 / t1, alg2);

    }
}