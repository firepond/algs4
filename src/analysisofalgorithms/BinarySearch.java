package analysisofalgorithms;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

/**
 * @author firepond algs4 exercise 1.4.10
 */

public class BinarySearch {

    public static int binarySearch(int[] array, int element, int low, int high) {
        if (low > high) {
            return -1;
        }

        int middle = low + (high - low) / 2;

        if (array[middle] < element) {
            return binarySearch(array, element, middle + 1, high);
        } else if (array[middle] > element) {
            return binarySearch(array, element, low, middle - 1);
        } else {
            int possibleSmallestIndex = binarySearch(array, element, low, middle - 1);

            if (possibleSmallestIndex == -1) {
                return middle;
            } else {
                return possibleSmallestIndex;
            }
        }
    }

    public static void main(String[] args) {
        String whiteListFile = "./test_data/1/4/10.txt";
        int[] whiteList = new In(whiteListFile).readAllInts();
        Arrays.sort(whiteList);
        StdOut.println(binarySearch(whiteList, 3, 0, whiteList.length));
    }

}