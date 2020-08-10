package fundmentals.analysisofalgorithms;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;

import java.util.Arrays;

/**
 * @author firepond algs4 exercise 1.4.8
 */

public class Exercise8 {

    public static void main(String[] args) {
        String fileName = "./test_data/1/4/8.txt";
        In in = new In(fileName);
        int[] intArray = in.readAllInts();
        StdOut.println(findEqualPairs(intArray));
    }

    public static int findEqualPairs(int[] a) {
        int count = 0;

        int[] array = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            array[i] = a[i];
            StdOut.print(a[i]);
        }
        StdOut.println();
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            StdOut.print(array[i]);
        }
        StdOut.println();
        int currentIndex = 1;

        int current = array[0];

        int samecount = 1;

        while (currentIndex < array.length) {
            if (array[currentIndex] == current) {
                samecount++;
            } else {
                count += parisOfNumber(samecount);
                samecount = 1;
                current = array[currentIndex];
            }
            currentIndex++;
        }
        count += parisOfNumber(samecount);

        return count;
    }

    public static int parisOfNumber(int n) {
        return n * (n - 1) / 2;
    }
}
