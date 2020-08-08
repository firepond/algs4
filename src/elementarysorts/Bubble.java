package elementarysorts;

import edu.princeton.cs.algs4.*;

public class Bubble extends Sort {

    @SuppressWarnings("rawtypes")
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = N - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (less(a[j + 1], a[j])) {
                    exch(a, j + 1, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        In in = new In("./algs4-data/tiny.txt");
        String[] a = in.readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}