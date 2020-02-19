package programmingmodel;

/**
 * @author firepond
 * algs4 exercise 1.1.18
 */

import edu.princeton.cs.algs4.*;

public class Exercise18 {

    public static void main(String[] args) {
        StdOut.println("mystery(2, 25):" + mystery(2, 25));
        StdOut.println("mystery(3, 11):" + mystery(3, 11));

    }

    public static int mystery(int a, int b) {
        if (b == 0) {
            return 0;
        }
        if (b % 2 == 0) {
            return mystery(a + a, b / 2);
        }
        return mystery(a + a, b / 2) + a;
    }

}