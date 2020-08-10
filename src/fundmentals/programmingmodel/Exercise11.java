package fundmentals.programmingmodel;

import edu.princeton.cs.algs4.*;

public class Exercise11 {

    public static void main(String[] args) {
        boolean[][] a = new boolean[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == j) {
                    a[i][j] = true;
                } else {
                    a[i][j] = false;
                }
            }
        }
        printBooleanArrays(a);
    }

    public static void printBooleanArrays(boolean[][] a) {
        int columnDimension = getMaxLineLength(a);
        int lineDimension = a.length;
        StdOut.print("   ");
        for (int i = 1; i <= columnDimension; i++) {
            StdOut.printf("%3d", i);
        }
        StdOut.println();
        for (int line = 0; line < lineDimension; line++) {
            StdOut.printf("%3d", line + 1);
            for (boolean b : a[line]) {
                if (b) {
                    StdOut.print("  *");
                } else {
                    StdOut.print("   ");
                }

            }
            StdOut.println();
        }
    }

    private static int getMaxLineLength(boolean[][] a) {
        int max = 0;
        for (boolean b[] : a) {
            if (b.length > max) {
                max = b.length;
            }
        }
        return max;
    }

}
