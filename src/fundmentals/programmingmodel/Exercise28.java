package fundmentals.programmingmodel;

/**
 * @author firepond
 * algs4 exercise 1.1.28
 */

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise28 {

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

    public static int[] removeDuplicates(int[] list) {
        int[] filteredList = new int[list.length];
        filteredList[0] = list[0];
        int count = 1;
        for (int i = 1; i < list.length; i++) {
            if (list[i] > filteredList[count]) {
                filteredList[count++] = list[i];
            }
        }

        int[] compactNewWhitelist = new int[count];
        System.arraycopy(filteredList, 0, compactNewWhitelist, 0, count);

        return compactNewWhitelist;
    }

    public static void main(String[] args) {
        int[] whiteList = { 1, 2, 3, 4, 5, 6, 6, 7, 7, 8 };
        int[] keys = { 1, 4, 5, 9, 10 };

        Arrays.sort(whiteList);

        int[] compactWhitelist = removeDuplicates(whiteList);

        for (int key : keys) {
            if (rank(key, compactWhitelist) == -1) {
                StdOut.println(key);
            }
        }

    }
}
