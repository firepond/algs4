package fundamentals.programmingmodel;

/**
 * @author firepond
 * algs4 exercise 1.1.32
 */

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

public class Exercise32 {

    public static void main(String[] args) {
        double l = 0;
        double r = 12;
        int N = 4;
        double numbers[] = { 0, 1, 1, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int[] frequency = getFrequency(numbers, l, r, N);
        StdOut.println(frequency[0] + " " + frequency[1]);
        drawHistrogram(frequency);
    }

    public static void drawHistrogram(int[] data) {
        double[] frequencies = new double[data.length];
        int addUp = 0;
        for (int i = 0; i < data.length; i++) {
            addUp += data[i];
        }
        for (int i = 0; i < data.length; i++) {
            frequencies[i] = (double) data[i] / addUp;
        }
        drawHistrogram(frequencies);
    }

    public static void drawHistrogram(double[] data) {
        StdDraw.setCanvasSize(640, 640);
        Arrays.sort(data);

        int N = data.length;
        double max = data[N - 1];

        StdOut.print(max);

        StdDraw.setXscale(-0.5 * N, 2.5 * N);
        StdDraw.setYscale(max * (-1) / 3, max * 5 / 3);
        StdDraw.line(0, max * (-0.05), 2 * N + 1, max * (-0.05));
        StdDraw.line(-1, 0, -1, max * 4 / 3);
        double halfWidth = 1.0;
        for (int i = 0; i < N; i++) {
            double x = halfWidth * (2 * i + 1);
            double y = data[i] / 2.0;
            double rw = halfWidth;
            double rh = data[i] / 2.0;
            StdDraw.filledRectangle(x, y, rw, rh);
            StdDraw.text(N, max * 1.5, "Histogram");
            // StdOut.println(
            // "i:" + i + ", x:" + x + ", y:" + y + ", rw:" + rw + ", rh:" + rh + ",
            // numbers[i]:" + data[i]);

        }
    }

    public static int[] getFrequency(double[] data, double l, double r, int N) {
        int[] frequency = new int[N];
        double width = (r - l) / N;
        double leftBound = l;
        double rightBound = l + width;
        int pos = 0;
        while (data[pos] < leftBound) {
            pos++;
        }
        for (int i = 0; i < N; i++, leftBound = rightBound, rightBound += width) {
            while (pos < data.length && data[pos] <= rightBound) {
                frequency[i]++;
                pos++;
            }
        }

        return frequency;

    }

}
