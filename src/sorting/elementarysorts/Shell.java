package sorting.elementarysorts;
import edu.princeton.cs.algs4.*;

public class Shell extends Sort {

    @SuppressWarnings("rawtypes")
    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h /= 3;
        }
    }

    public static void main(String[] args) {
        In in = new In("./algs4-data/tiny.txt");
        String s = "E A S Y S H E L L S O R T Q U E S T I O N";
        String[] a = s.split(" ");
        sort(a);
        assert isSorted(a);
        show(a);
    }
}