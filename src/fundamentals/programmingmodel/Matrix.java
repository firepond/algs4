package fundamentals.programmingmodel;

/**
 * @author firepond
 * algs4 exercise 1.1.33
 */

import edu.princeton.cs.algs4.StdOut;

public class Matrix {

    public static void main(String[] args) {
        double[] va = { 1, 2, 3 };
        double[] vb = { 1, 2, 3 };

        double na = dot(va, vb);
        print(na);

        double[][] ma = { { 1, 0 }, { 0, 1 } };
        double[][] mb = { { 1, 1 }, { 1, 1 } };
        double[][] mc = mult(ma, mb);
        print(mc);

        double[][] md = { { 1, 2, 3 }, { 1, 2, 3 } };
        double[][] md_trans = transpose(md);
        print(md_trans);

        double[][] rm = { { 1, 2 }, { 3, 4 } };
        double[] lv = { 1, 2 };
        double[] pv = mult(lv, rm);
        print(pv);
    }

    public static void print(double x) {
        StdOut.println(x);
    }

    public static void print(double[] x) {
        for (int i = 0; i < x.length; i++) {
            StdOut.printf("%.2f ", x[i]);
        }
        StdOut.println();
    }

    public static void print(double[][] x) {
        for (int i = 0; i < x.length; i++) {
            print(x[i]);
        }
        StdOut.println();
    }

    public static double dot(double[] x, double[] y) {
        if (x == null || y == null || x.length != y.length) {
            throw new IllegalArgumentException();
        }

        double result = 0;

        for (int i = 0; i < x.length; i++) {
            result += x[i] * y[i];
        }

        return result;
    }

    public static double[][] mult(double[][] a, double[][] b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Null matrix");
        }

        if (!isMatrix(a) || !isMatrix(b)) {
            throw new IllegalArgumentException("Not a matrix");
        }

        if (a[0].length != b.length) {
            throw new IllegalArgumentException("Can not multiply");
        }

        double[][] result = new double[a.length][b[0].length];

        for (int row = 0; row < a.length; row++) {
            for (int column = 0; column < b[0].length; column++) {
                for (int k = 0; k < b.length; k++) {
                    result[row][column] += a[row][k] * b[k][column];
                }
            }
        }
        return result;
    }

    public static double[][] transpose(double[][] x) {
        if (x == null) {
            throw new IllegalArgumentException("Null matrix");
        }

        if (!isMatrix(x)) {
            throw new IllegalArgumentException("Not a matrix");
        }

        double transpose[][] = new double[x[0].length][x.length];

        for (int row = 0; row < x.length; row++) {
            for (int column = 0; column < x[0].length; column++) {
                transpose[column][row] = x[row][column];
            }
        }

        return transpose;
    }

    public static double[] mult(double[][] a, double[] x) {
        if (x == null || a == null) {
            throw new IllegalArgumentException("Null matrix");
        }

        if (!isMatrix(a)) {
            throw new IllegalArgumentException("Not a matrix");
        }

        if (a[0].length != x.length) {
            throw new IllegalArgumentException("Can not multiply");
        }

        double[] result = new double[a.length];

        for (int row = 0; row < result.length; row++) {
            for (int column = 0; column < x.length; column++) {
                result[row] += a[row][column] * x[column];
            }
        }

        return result;
    }

    public static double[] mult(double[] y, double[][] a) {
        if (y == null || a == null) {
            throw new IllegalArgumentException("Null matrix");
        }

        if (!isMatrix(a)) {
            throw new IllegalArgumentException("Not a matrix");
        }

        if (a.length != y.length) {
            throw new IllegalArgumentException("Can not multiply");
        }

        double[] result = new double[a[0].length];

        for (int column = 0; column < result.length; column++) {
            for (int row = 0; row < y.length; row++) {
                result[column] += a[row][column] * y[row];
            }
        }

        return result;
    }

    public static boolean isMatrix(double[][] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i].length != a[0].length) {
                return false;
            }
        }

        return true;
    }

}
