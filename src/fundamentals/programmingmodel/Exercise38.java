package fundamentals.programmingmodel;

/**
 * @author firepond
 * algs4 exercise 1.1.38
 */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import java.util.Arrays;

public class Exercise38 {

    public static void main(String[] args) {

        int[] whiteList = new In(args[0]).readAllInts();
        int[] keys = new In(args[1]).readAllInts();
        Arrays.sort(whiteList);

        long start = System.currentTimeMillis();

        StdOut.println("Start binary search");

        for (int key : keys) {
            if (binaryRank(key, whiteList) == -1) {
                // StdOut.println(key);
            }
        }

        long end = System.currentTimeMillis();
        long diff = end - start;

        System.out.println("Binary serach time: " + diff);

        start = System.currentTimeMillis();

        StdOut.println("Start brute search");

        for (int key : keys) {
            if (bruteRank(key, whiteList) == -1) {
                // StdOut.println(key);
            }
        }

        end = System.currentTimeMillis();
        diff = end - start;
        System.out.println("Brute search time: " + diff);

    }

    public static int bruteRank(int key, int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static int binaryRank(int key, int[] a) {
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
}
