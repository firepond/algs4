package fundamentals.programmingmodel;

/**
 * @author firepond
 * algs4 exercise 1.1.30
 */

import edu.princeton.cs.algs4.StdOut;

public class Exercise30 {

    public static void main(String[] args) {
        boolean[][] a = createCoprimeMatrix(10);
        printBooleanMatrix(a);
    }

    public static boolean[][] createCoprimeMatrix(int a) {
        boolean[][] coprime = new boolean[a][a];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                if (gcd(i, j) == 1) {
                    coprime[j][i] = true;
                } else {
                    coprime[j][i] = false;
                }
            }
        }
        return coprime;
    }

    public static void printBooleanMatrix(boolean[][] matrix) {
        int rows = matrix.length;
        StdOut.print("    ");
        for (int i = 0; i < matrix[0].length; i++) {
            StdOut.printf("%2d    ", i);
        }
        StdOut.println();

        for (int i = 0; i < rows; i++) {
            StdOut.printf("%2d  ", i);
            int columns = matrix[i].length;
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == true) {
                    StdOut.print("true  ");
                } else {
                    StdOut.print("false ");
                }
            }
            StdOut.println();
        }
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
