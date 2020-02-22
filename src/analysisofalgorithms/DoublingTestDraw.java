package analysisofalgorithms;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.Draw;

/**
 * @author firepond algs4 exercise 1.4.3
 */

public class DoublingTestDraw {
    private static final int MAXIMUM_INTEGER = 1000000;

    

    double[] x = new double[10];
    double[] xLog = new double[10];
    double[] y = new double[10];
    double[] yLog = new double[10];

    double xMin = 0;
    double xMax = 1;
    double yMin = 0;
    double yMax = 1;

    int count = 0;

    public DoublingTestDraw() {
        StdDraw.setCanvasSize(500, 500);
        StdDraw.clear(StdDraw.BLACK);
    }

    public static double timeTrial(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniform(-MAXIMUM_INTEGER, MAXIMUM_INTEGER);
        }
        Stopwatch timer = new Stopwatch();
        ThreeSum.count(a);
        return timer.elapsedTime();
    }

    public void draw() {
        StdDraw.clear(StdDraw.BLACK);
        if (x[count] > xMax) {
            xMax = x[count] * 1.2;
        }
        if (xLog[count] < xMin) {
            xMin = xLog[count] * 1.2;
        }
        if (y[count] > yMax) {
            yMax = y[count] * 1.2;
        }
        if (yLog[count] < yMin) {
            yMin = yLog[count] * 1.2;
        }

        StdDraw.setXscale(xMin, xMax);
        StdDraw.setYscale(yMin, yMax);

        StdDraw.setPenRadius(0.001);

        StdDraw.setPenColor(StdDraw.WHITE);

        StdDraw.line(xMin, 0, xMax, 0);
        StdDraw.line(0, yMin, 0, yMax);
        StdDraw.setPenRadius(0.01);

        for (int i = 0; i < count; i++) {
            StdDraw.setPenColor(StdDraw.WHITE);

            StdDraw.point(x[i], y[i]);

            StdDraw.setPenColor(StdDraw.RED);

            StdDraw.point(xLog[i], yLog[i]);
        }
    }

    public static void main(String[] args) {
        DoublingTestDraw draw = new DoublingTestDraw();
        Double loge2 = Math.log(2);
        for (int n = 250; true; n += n, draw.count++) {
            double time = timeTrial(n);
            StdOut.printf("%7d %7.1f\n", n, time);
            draw.x[draw.count] = n;
            draw.y[draw.count] = time;
            draw.xLog[draw.count] = Math.log(n) * loge2;
            draw.yLog[draw.count] = Math.log(time) * loge2;
            draw.draw();
        }
    }

}
