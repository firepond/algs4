package programmingmodel;

import edu.princeton.cs.algs4.*;

public class Exercise3 {

    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        boolean equal = compare_three_number(a, b, c);
        if (equal) {
            StdOut.println("equal");
        } else {
            StdOut.println("not equal");

        }
    }

    public static boolean compare_three_number(int a, int b, int c) {
        if (a == b && b == c) {
            return true;
        } else {
            return false;
        }
    }
}