package test;

import edu.princeton.cs.algs4.StdDraw;

public class DrawTest {
    public static void main(String[] args) {
        // int N = 100;

        StdDraw.setCanvasSize(500, 500);

        int xScale = 10;
        int yScale = 10;
        int xScaleNegative = (-1) * xScale;
        int yScaleNegative = (-1) * yScale;

        StdDraw.setXscale(xScaleNegative, xScale);
        StdDraw.setYscale(yScaleNegative, yScale);

        StdDraw.clear(StdDraw.BLACK);
        StdDraw.setPenRadius(0.001);
        StdDraw.setPenColor(StdDraw.WHITE);

        // StdDraw.point(5, 5);
        // StdDraw.point(10, 10);
        // StdDraw.point(10, 0);
        // StdDraw.point(0, 10);
        // StdDraw.point(0, 0);

        StdDraw.line(xScaleNegative, 0, xScale, 0);
        StdDraw.line(0, yScale, 0, yScaleNegative);

        for (double p = -1; p <= 1; p += 0.005) {
            StdDraw.point(p, p * p);
        }
    }

}