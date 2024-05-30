package fundamentals.programmingmodel;

/**
 * @author firepond
 * algs4 exercise 1.1.22
 */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import java.util.Arrays;

public class Exercise22 {
    public static int rank(int key, int[] a) {
        return rank(key, a, 0, a.length - 1, 0);
    }

    public static int rank(int key, int[] a, int lo, int hi, int reCount) {
        for (int i = 0; i < reCount; i++) {
            StdOut.print("  ");
        }
        StdOut.println("lo:" + lo + " - hi:" + hi);
        if (lo > hi) {
            return -1;
        }
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) {
            return rank(key, a, lo, mid - 1, ++reCount);
        } else if (key > a[mid]) {
            return rank(key, a, mid + 1, hi, ++reCount);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int[] whiteList = new In(args[0]).readAllInts();
        int[] keys = new In(args[1]).readAllInts();
        Arrays.sort(whiteList);
        for (int key : keys) {
            if (rank(key, whiteList) == -1) {
                StdOut.println(key);
            }
        }

    }
}
