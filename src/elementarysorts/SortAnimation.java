package elementarysorts;

import java.util.Random;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Draw;
import edu.princeton.cs.algs4.StdDraw;

//Exercise 2.1.17

public class SortAnimation {

    public static void exch(double[] a, int i, int j) {
        double t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void selectionSort(double[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }

    public static void insertionSort(double[] a, Draw d) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            show(d, a);
            for (int j = i; j > 0 && a[j] < a[j - 1]; j--) {
                exch(a, j, j - 1);
            }
        }
    }

    public static boolean isSorted(double[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void show(Draw draw, double[] a) {
        draw.clear();
        int N = a.length;
        int x = 3;
        for (int i = 0; i < N; i++) {
            double y = a[i] / 2;
            draw.filledRectangle(x, y, 1, y);
            x += 3;
        }
        draw.pause(1000);
    }

    public static void main(String[] args) {
        Random random = new Random();
        double[] a = new double[20];
        for (int i = 0; i < 20; i++) {
            a[i] = random.nextDouble();
        }
        Draw d = new Draw();
        int N = a.length;
        int height = 200;
        int columnwidth = 30;
        int halfColumnWidth = columnwidth / 2;
        int width = N * columnwidth + N * halfColumnWidth - halfColumnWidth + 2 * columnwidth;
        d.clear();
        d.setCanvasSize(width, height);
        d.setPenColor(Draw.GRAY);
        d.setXscale(0, 3 * N + 3);
        d.setYscale(0, 1.2);
        insertionSort(a, d);
        assert isSorted(a);
        show(d, a);
    }

}