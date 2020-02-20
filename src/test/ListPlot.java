package test;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;

public class ListPlot {
    public static void main(String[] args) {
        var fileName = "ThreeSum.txt";

        var in = new In(fileName);

        var data = in.readAllDoubles();

        var x = new Double[data.length / 2];
        var y = new Double[data.length / 2];
        var lny = new Double[data.length / 2];
        var lnx = new Double[data.length / 2];

        for (int i = 0; i < x.length; i++) {
            x[i] = data[2 * i];
            y[i] = data[2 * i + 1];
            lny[i] = Math.log(y[i]);
            lnx[i] = Math.log(y[i]);
        }

        StdOut.println("x");
        for (var a : x) {
            StdOut.println(a);
        }

        StdOut.println("y");
        for (var a : y) {
            StdOut.println(a);
        }

        StdOut.println("lny");
        for (var a : lny) {
            StdOut.println(a);
        }

        StdOut.println("lnx");
        for (var a : lnx) {
            StdOut.println(a);
        }

        StdDraw.setCanvasSize(500, 500);

        double xScale = lnx[lny.length - 1] * 1.2;
        double yScale = lny[lny.length - 1] * 1.2;
        double xScaleNegative = lnx[0] * 1.2;
        double yScaleNegative = lny[0] * 1.2;

        StdDraw.setXscale(xScaleNegative, xScale);
        StdDraw.setYscale(yScaleNegative, yScale);

        StdDraw.clear(StdDraw.BLACK);
        StdDraw.setPenRadius(0.001);
        StdDraw.setPenColor(StdDraw.WHITE);

        StdDraw.line(xScaleNegative, 0, xScale, 0);
        StdDraw.line(0, yScale, 0, yScaleNegative);
        StdDraw.setPenRadius(0.01);

        for (int i = 0; i < x.length; i++) {
            StdDraw.point(lnx[i], lny[i]);
        }
    }

}