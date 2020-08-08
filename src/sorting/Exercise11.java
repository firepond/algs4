package sorting;

import java.util.ArrayList;

//Shell sort which sort store h in an array instead of calculating it in real-time.
public class Exercise11 extends Sort {

    @SuppressWarnings("rawtypes")
    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        while (h < N / 3) {
            h = 3 * h + 1;
            list.add(h);
        }
        Integer[] hs = new Integer[list.size()];
        hs = list.toArray(hs);
        int hIndex = hs.length - 1;
        while (hIndex >= 0) {
            h = hs[hIndex];
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            hIndex--;
        }
    }

    public static void main(String[] args) {
        String s = "E A S Y S H E L L S O R T Q U E S T I O N";
        String[] a = s.split(" ");
        sort(a);
        assert isSorted(a);
        show(a);
    }
}