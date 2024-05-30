package fundamentals.programmingmodel;

/**
 * @author firepond
 * algs4 exercise 1.1.39
 */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Exercise39 {

    public static void main(String[] args) {
        int t = 100;

        int n1 = (int) Math.pow(10, 3);
        int n2 = (int) Math.pow(10, 4);
        int n3 = (int) Math.pow(10, 5);
        int n4 = (int) Math.pow(10, 6);

        int[] results = new int[4];

        for (int i = 0; i < t; i++) {
            results[0] += randomMatch(n1);
            results[1] += randomMatch(n2);
            results[2] += randomMatch(n3);
            results[3] += randomMatch(n4);
        }

        StdOut.println("Results");

        String a = "abc.def";
        a.charAt(0);

        StdOut.printf("10ˆ3: %7.2f \n", ((double) results[0]) / t);
        StdOut.printf("10ˆ4: %7.2f \n", ((double) results[1]) / t);
        StdOut.printf("10ˆ5: %7.2f \n", ((double) results[2]) / t);
        StdOut.printf("10ˆ6: %7.2f \n", ((double) results[3]) / t);

    }

    public static double randomMatch(int N) {
        int[] array1 = new int[N];
        int[] array2 = new int[N];

        for (int i = 0; i < N; i++) {
            array1[i] = StdRandom.uniform(100000, 1000000);
            array2[i] = StdRandom.uniform(100000, 1000000);
        }

        Arrays.sort(array1);
        Arrays.sort(array2);

        int numbersInBothArrays = 0;

        for (int i = 0; i < N; i++) {

            if (binarySearch(array1[i], array2, 0, array2.length - 1)) {
                numbersInBothArrays++;
            }

        }

        return numbersInBothArrays;
    }

    public static boolean binarySearch(int key, int[] arr, int lo, int hi) {

        boolean found = false;

        if (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (key < arr[mid]) {
                binarySearch(key, arr, lo, mid - 1);
            } else if (key > arr[mid]) {
                binarySearch(key, arr, mid + 1, hi);
            } else {
                found = true;
            }
        } else {
            found = false;
        }

        return found;
    }

}
