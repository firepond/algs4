package fundamentals.programmingmodel;

import edu.princeton.cs.algs4.*;

public class Exercise5 {

    public static void main(String[] args) {
        double x = 0.5f;
        double y = 1.5f;
        StdOut.println(isStrictlyBetween0and1(x) && isStrictlyBetween0and1(y));

    }

    public static boolean isStrictlyBetween0and1(double a) {
        if (a > 0 && a < 1) {
            return true;
        } else {
            return false;
        }
    }

}