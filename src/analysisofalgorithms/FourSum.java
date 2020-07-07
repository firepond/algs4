package analysisofalgorithms;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.BinarySearch;

/**
 * @author firepond algs4 exercise 1.4.14
 */

public class FourSum {

    public static void main(String[] args) {
        int[] setA = { 1, 2, 3, -6, 1, 4, 5 };
        StdOut.println(fourSumCount(setA));
    }

    public static int fourSumCount(int[] array) {
        int count = 0;
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                for (int k = j + 1; k < array.length; k++) {
                    if (BinarySearch.indexOf(array, -array[i] - array[j] - array[k]) > k) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
