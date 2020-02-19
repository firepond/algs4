package programmingmodel;

/**
 * @author firepond
 * algs4 exercise 1.1.20
 */

import edu.princeton.cs.algs4.*;

public class Exercise20 {

    public static void main(String[] args) {
        StdOut.println(logarithmFactorial(300));

    }

    public static double logarithmFactorial(int N) {
        if (N == 0) {
            return 0;
        }

        return logarithmFactorial(N - 1) + Math.log(N);
    }
}
