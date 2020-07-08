package sorting;

import java.lang.Comparable;
import edu.princeton.cs.algs4.*;

public class SortExample {
    @SuppressWarnings("rawtypes")
    public static void sort(Comparable[] a) {

    }

    /**
     * if v < w, return ture
     */
    @SuppressWarnings(value = { "rawtypes", "unchecked" })
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    @SuppressWarnings("rawtypes")
    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    @SuppressWarnings("rawtypes")
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i] + " ");
        }
        StdOut.println();
    }

    @SuppressWarnings("rawtypes")
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }

}