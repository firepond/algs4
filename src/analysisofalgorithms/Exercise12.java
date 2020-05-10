package analysisofalgorithms;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author firepond algs4 exercise 1.4.12
 */

public class Exercise12 {

    public static void main(String[] args) {
        int[] setA = { 1, 2, 3, 3, 4, 5 };
        int[] setB = { 1, 2, 3, 3, 4, 5 };
        printIntersection(setA, setB);
    }

    public static void printIntersection(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);

        // Brute
        // for (int i = 0; i < a.length; i++) {
        // for (int j = 0; j < b.length; j++) {
        // if (a[i] == b[j]) {
        // StdOut.println(a[i]);
        // }
        // }
        // }

        // O(N)
        for (int i = 0, j = 0; i < a.length; i++) {
            while (j < b.length && b[j] < a[i]) {
                j++;
            }
            if (j < b.length && b[j] == a[i]) {
                StdOut.println(a[i]);
            }
        }
    }
}
