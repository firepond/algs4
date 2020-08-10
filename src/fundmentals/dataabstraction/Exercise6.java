package fundmentals.dataabstraction;

/**
 * @author firepond
 * algs4 exercise 1.2.6
 */

import edu.princeton.cs.algs4.StdOut;

public class Exercise6 {

    public static void main(String[] args) {
        StdOut.println(isCircularRotation("ACTGACG", "TGACGAC"));
    }

    public static boolean isCircularRotation(String s, String t) {
        return (s.length() == t.length()) && (s.concat(s).indexOf(t) >= 0);
    }
}
