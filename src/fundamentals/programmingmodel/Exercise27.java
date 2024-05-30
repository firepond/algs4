package fundamentals.programmingmodel;

/**
 * @author firepond
 * algs4 exercise 1.1.27
 */

import edu.princeton.cs.algs4.StdOut;

public class Exercise27 {

    double[][] binomialDistribution;
    double p;
    double np;

    public static void main(String[] args) {
        StdOut.println(binomial2Init(100, 50, 0.5));
    }

    Exercise27(int N, int k, double p) {
        this.p = p;
        this.np = 1 - p;
        binomialDistribution = new double[N + 1][k + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= k; j++) {
                binomialDistribution[i][j] = -1;
            }
        }
    }

    public static double binomial(int N, int k, double p) {
        // StdOut.println("N:" + N + " k:" + k);
        // StdOut.println(count);
        if (N == 0 && k == 0) {
            return 1.0;
        }
        if (N < 0 || k < 0) {
            return 0.0;
        }
        return (1.0 - p) * binomial(N - 1, k, p) + p * binomial(N - 1, k - 1, p);
    }

    public static double binomial2Init(int N, int k, double p) {
        if (N == 0 && k == 0) {
            return 1;
        }
        Exercise27 instance = new Exercise27(N, k, p);
        return instance.binomial2(N, k);
    }

    public double binomial2(int N, int k) {

        // StdOut.println("N:" + N + " ,K:" + k);

        if (N == 0 && k == 0) {
            return 1;
        }

        if (N < 0 || k < 0) {
            return 0;
        }

        if (binomialDistribution[N][k] == -1) {
            binomialDistribution[N][k] = binomial2(N - 1, k - 1) * p + binomial2(N - 1, k) * np;
        }
        return binomialDistribution[N][k];
    }

}
