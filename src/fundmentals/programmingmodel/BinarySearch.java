package fundmentals.programmingmodel;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

public class BinarySearch {

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