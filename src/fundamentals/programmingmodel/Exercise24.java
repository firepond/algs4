package fundamentals.programmingmodel;

/**
 * @author firepond
 * algs4 exercise 1.1.24
 */

import edu.princeton.cs.algs4.StdOut;

public class Exercise24 {

    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        StdOut.println("The gcd of " + a + " and " + b + " is " + gcd(a, b));

    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

}
