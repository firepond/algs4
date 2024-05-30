package fundamentals.analysisofalgorithms;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author firepond algs4 exercise 1.4.20
 */

public class Exercise20 {

    public static void main(String[] args) {
        int[] array = { 0, 1, 2, 3, 4, 8, 5, 4, 3, 2, 1, };
        boolean b = bitonicSearch(array, 5);
        StdOut.println(b);
    }

    public static boolean bitonicSearch(int[] array, int target) {
        int N = array.length;
        // find max
        int low = 0;
        int high = N;
        int mid = (low + high) / 2;
        int max = 0;
        while (true) {
            mid = (low + high) / 2;
            if (array[mid - 1] < array[mid] && array[mid + 1] < array[mid]) {
                max = mid;
                break;
            }
            if (array[mid + 1] > array[mid]) {
                low = mid;
            } else {
                high = mid;
            }
        }
        int center = mid;
        // left half search
        low = 0;
        high = center;
        while (low < high) {
            mid = (low + high) / 2 + 1;
            if (array[mid] == target) {
                return true;
            }
            if (array[mid] >= target) {
                high = mid;
            } else {
                low = mid;
            }
        }
        low = center;
        high = N;
        // right half search
        while (low < high) {
            mid = (low + high) / 2 + 1;
            if (array[mid] == target) {
                return true;
            }

            if (array[mid] >= target) {
                low = mid;
            } else {
                high = mid;
            }
        }
        // StdOut.println(mid);
        return false;
    }
}
