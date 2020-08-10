package fundmentals.programmingmodel;

/**
 * @author firepond
 * algs4 exercise 1.1.29
 */

import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

public class Exercise29 {

    public static void main(String[] args) {

        int[] array = { 1, 2, 4, 4, 5, 6, 6, 7, 7, 7, 8 };

        Arrays.sort(array);

        // StdOut.println("Rank: " + rank(0, array) + " Expected: 0");

        // StdOut.println("Rank: " + rank(1, array) + " Expected: 0");

        // StdOut.println("Rank: " + rank(5, array) + " Expected: 4");
        // StdOut.println("Rank: " + rank(7, array) + " Expected: 7");

        // StdOut.println("Rank: " + rank(8, array) + " Expected: 10");

        // StdOut.println("Rank: " + rank(9, array) + " Expected: 11");

        StdOut.println("tailRank: " + tailRank(0, array) + " Expected: 11");

        StdOut.println("tailRank: " + tailRank(1, array) + " Expected: 10");

        StdOut.println("tailRank: " + tailRank(5, array) + " Expected: 6");
        StdOut.println("tailRank: " + tailRank(7, array) + " Expected: 1");

        StdOut.println("tailRank: " + tailRank(8, array) + " Expected: 0");

        StdOut.println("tailRank: " + tailRank(9, array) + " Expected: 0");

        StdOut.println("Verification: " + verify(7, array) + " Expected: true");

        StdOut.println();

    }

    public static int rank(int key, int[] array) {
        if (array[0] >= key) {
            return 0;
        }
        if (array[array.length - 1] < key) {
            return array.length;
        }
        int low = 0;
        int high = array.length - 1;
        int index = (high + low) / 2;
        while (array[index] >= key || array[index + 1] < key) {
            index = (high + low) / 2;

            if (array[index + 1] < key) {
                low = index + 1;
            } else {
                // array[index] >= key
                high = index;
            }
        }
        return index + 1;
    }

    public static int tailRank(int key, int[] array) {
        if (key < array[0]) {
            return array.length;
        }
        if (key >= array[array.length - 1]) {
            return 0;
        }
        int low = 0;
        int high = array.length - 1;
        int index = (high + low) / 2;
        // array[index] > key && array[index - 1] <= key
        while (array[index] <= key || array[index - 1] > key) {
            index = (high + low) / 2 + 1;

            if (array[index] <= key) {
                low = index;
            } else {
                // array[index - 1] > key
                high = index - 1;
            }
        }
        return array.length - index;
    }

    public static int count(int key, int[] array) {
        return array.length - rank(key, array) - tailRank(key, array);
    }

    private static boolean verify(int key, int[] array) {

        int indexFromRank = rank(key, array);
        int count = count(key, array);

        Arrays.sort(array);

        if (array[indexFromRank] == key && array[indexFromRank + count - 1] == key) {
            return true;
        } else {
            return false;
        }

    }

}
