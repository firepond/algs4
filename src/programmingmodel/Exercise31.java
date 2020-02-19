package programmingmodel;

/**
 * @author firepond
 * algs4 exercise 1.1.31
 */

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise31 {

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double p = Double.parseDouble(args[1]);

        StdDraw.setCanvasSize(500, 500);

        double xScale = 1.2;
        double yScale = 1.2;
        double xScaleNegative = (-1) * xScale;
        double yScaleNegative = (-1) * yScale;

        StdDraw.setXscale(xScaleNegative, xScale);
        StdDraw.setYscale(yScaleNegative, yScale);

        StdDraw.clear(StdDraw.DARK_GRAY);
        StdDraw.setPenRadius(0.001);
        StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);

        double radius = 1;
        StdDraw.circle(0, 0, radius);

        // StdDraw.setPenColor(StdDraw.RED);
        StdDraw.setPenRadius(0.005);
        double angle = 2 * Math.PI / N;
        double positions[][] = new double[N][2];
        for (int i = 0; i < N; i++) {
            positions[i][0] = Math.cos(angle * i);
            positions[i][1] = Math.sin(angle * i);
            StdDraw.point(positions[i][0], positions[i][1]);
        }

        StdDraw.setPenRadius(0.001);

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (StdRandom.bernoulli(p)) {
                    StdDraw.line(positions[i][0], positions[i][1], positions[j][0], positions[j][1]);
                }
            }
        }

    }

}
