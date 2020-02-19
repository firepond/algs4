package programmingmodel;

/**
 * @author firepond
 * algs4 exercise 1.1.14
 */

import edu.princeton.cs.algs4.*;

public class Exercise14 {

    public static void main(String[] args) {
        int x = lg(15);
        StdOut.println(x);

    }

    public static int lg(int n) {
        int result = 1;
        int power = 0;
        int base = 2;
        while (result <= n) {
            result *= base;
            power++;
        }
        return --power;

    }
  
}
