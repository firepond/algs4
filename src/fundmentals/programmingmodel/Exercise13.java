package fundmentals.programmingmodel;

/**
 * @author firepond
 * algs4 exercise 1.1.13
 */

import edu.princeton.cs.algs4.*;

public class Exercise13 {

    public static void main(String[] args) {
        int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        printArray(mat);
        printArrayTranspose(mat);
    }

    public static void printArrayTranspose(int[][] a) {
        if (isMatrix(a) == false) {
            return;
        }

        int lineDimension = a.length;
        int columnDimension = a[0].length;

        for (int i = 0; i < columnDimension; i++) {
            for (int j = 0; j < lineDimension; j++) {
                StdOut.printf("%4d", a[j][i]);
            }
            StdOut.println("");
        }
        StdOut.println("");

    }

    public static void printArray(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                StdOut.printf("%4d", a[i][j]);
            }
            StdOut.println();
        }
        StdOut.println();

    }

    public static boolean isMatrix(int[][] a) {
        int lineDimension = a.length;
        int columnDimension = a[0].length;

        for (int i = 1; i < lineDimension; i++) {
            if (a[i].length != columnDimension) {
                return false;
            }
        }
        return true;

    }
}
