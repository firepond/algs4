package sorting;

import tools.ConsoleColors;

import edu.princeton.cs.algs4.*;

public class Shell extends Sort {

    @SuppressWarnings("rawtypes")
    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1;
        }
        ConsoleColors.printlnWithColor("h:" + h, ConsoleColors.Colors.RED);
        show(a);
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                    show(a);
                }
            }
            h /= 3;
            ConsoleColors.printlnWithColor("h:" + h, ConsoleColors.Colors.RED);
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