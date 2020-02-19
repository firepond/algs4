package programmingmodel;

/**
 * @author firepond
 * algs4 exercise 1.1.19
 */

import edu.princeton.cs.algs4.*;

public class Exercise19 {

    public static void main(String[] args) {
        for (int N = 0; N < 80; N++) {
            StdOut.println(N + " " + F2(N));
        }
    }

    public static long F(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        return F(N - 1) + F(N - 2);
    }

    public static long F2(int N) {
        long left = 1;
        long right = 1;
        long temp;
        for(int i=2;i<N;i++) {
            temp = right;
            right = left + right;
            left = temp;
        }
        return right;
    }
}
