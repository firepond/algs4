package fundamentals.analysisofalgorithms;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * @author firepond algs4 exercise 1.4.11
 */

public class StaticSETofInts {
    private int[] a;

    public StaticSETofInts(int[] keys) {

        a = new int[keys.length];
        for (int i = 0; i < keys.length; i++) {
            a[i] = keys[i];
        }

        Arrays.sort(a);

    }

    public boolean contains(int key) {
        return rank(key) != -1;
    }

    public int rank(int key) {
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

    public static int rank(int[] array, int element, int low, int high) {
        if (low > high) {
            return -1;
        }

        int middle = low + (high - low) / 2;

        if (array[middle] < element) {
            return rank(array, element, middle + 1, high);
        } else if (array[middle] > element) {
            return rank(array, element, low, middle - 1);
        } else {
            return middle;
        }
    }

    public int howMany(int key) {
        int smallestindex = 0;
        int low = 0;

        int biggestIndex = a.length - 1;
        int high = biggestIndex;
        while (rank(a, key, low, high) != -1) {
            low++;
        }
        biggestIndex = low;

        StdOut.println(smallestindex);

        low = 0;
        while (rank(a, key, low, high) != -1) {
            high--;
        }
        smallestindex = high;
        StdOut.println(biggestIndex);

        return biggestIndex - smallestindex - 1;
    }

    public static void main(String[] args) {
        String whiteListFile = "./test_data/1/4/11.txt";
        int[] whiteList = new In(whiteListFile).readAllInts();
        StaticSETofInts set = new StaticSETofInts(whiteList);
        StdOut.println(set.howMany(3));
    }
}