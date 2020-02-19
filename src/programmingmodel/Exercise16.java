package programmingmodel;

/**
 * @author firepond
 * algs4 exercise 1.1.16
 */

import edu.princeton.cs.algs4.*;

public class Exercise16 {

    public static void main(String[] args) {
        StdOut.println(exR1(6));
    }

    public static String exR1(int n) {
        if (n <= 0) {
            return "";
        }
        return exR1(n - 3) + n + exR1(n - 2) + n;
    }
}
