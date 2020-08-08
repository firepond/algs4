package elementarysorts;

import edu.princeton.cs.algs4.*;

public class Selection extends Sort {
    @SuppressWarnings("rawtypes")
    public static void sort(Comparable[] a) {
        int N = a.length;
        show(a);
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
            show(a);

        }
    }

    public static void main(String[] args) {
        In in = new In("./algs4-data/tiny.txt");
        String[] m = "E A S Y Q U E S T I O N".split(" ");
        String[] a = in.readAllStrings();
        sort(m);
        assert isSorted(m);
        show(m);
    }
}