package programmingmodel;

/**
 * @author firepond
 * algs4 exercise 1.1.23
 */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import java.util.Arrays;

public class Exercise23 {
    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] whiteList = new In(args[0]).readAllInts();
        int[] keys = new In(args[1]).readAllInts();
        Arrays.sort(whiteList);
        if (args[2].charAt(0) == '+') {
            for (int key : keys) {
                if (rank(key, whiteList) == -1) {
                    StdOut.println(key);
                }
            }
        } else if (args[2].charAt(0) == '-') {
            for (int key : keys) {
                if (rank(key, whiteList) != -1) {
                    StdOut.println(key);
                }
            }
        }

    }

}
