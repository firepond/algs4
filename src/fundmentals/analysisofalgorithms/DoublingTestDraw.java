package fundmentals.analysisofalgorithms;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Draw;

/**
 * @author firepond algs4 exercise 1.4.3
 */

public class DoublingTestDraw {
    private static final int MAXIMUM_INTEGER = 1000000;
    Draw draw = new Draw();

    double[] x = new double[10];
    double[] y = new double[10];

    double xMin = 0;
    double xMax = 0;
    double yMin = 0;
    double yMax = 0;

    int count = 0;

    public DoublingTestDraw() {
        draw.setCanvasSize(500, 500);
        draw.clear(Draw.BLACK);
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
        draw.clear(Draw.BLACK);
        if (x[count] >= xMax) {
            xMax = x[count] * 1.2;
        }
        if (x[count] <= xMin) {
            xMin = x[count] * 1.2;
        }
        if (y[count] >= yMax) {
            yMax = y[count] * 1.2;
        }
        if (y[count] <= yMin) {
            yMin = y[count] * 1.2;
        }

        draw.setXscale(xMin, xMax);
        draw.setYscale(yMin, yMax);

        draw.setPenRadius(0.001);

        draw.setPenColor(Draw.WHITE);

        draw.line(xMin, 0, xMax, 0);
        draw.line(0, yMin, 0, yMax);
        draw.setPenRadius(0.01);

        for (int i = 0; i <= count; i++) {
            draw.point(x[i], y[i]);
        }

    }

    public static void main(String[] args) {
        DoublingTestDraw linear = new DoublingTestDraw();
        DoublingTestDraw log = new DoublingTestDraw();
        Double loge2 = Math.log(2);
        for (int n = 250; true; n += n, linear.count++, log.count++) {
            double time = timeTrial(n);
            StdOut.printf("%7d %7.1f\n", n, time);
            linear.x[linear.count] = n;
            linear.y[linear.count] = time;
            linear.draw();
            log.x[log.count] = Math.log(n) * loge2;
            log.y[log.count] = Math.log(time) * loge2;
            log.draw();
        }
    }

}
