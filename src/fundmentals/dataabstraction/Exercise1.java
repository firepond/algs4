package fundmentals.dataabstraction;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author firepond
 * algs4 exercise 1.2.1
 */

public class Exercise1 {

    public static void main(String[] args) {
        // int N = Integer.parseInt(args[0]);
        int N = 10;
        Point2D[] points = generateRandomPoint2Ds(N);
        double shortestDisatnce = getShortestDistance(points);
        StdOut.println("Shortest distance:" + shortestDisatnce);

    }

    public static double getShortestDistance(Point2D[] points) {
        double min = points[0].distanceTo(points[1]);

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double distance = points[i].distanceTo(points[j]);
                if (distance < min) {
                    min = distance;
                }
            }
        }

        return min;
    }

    public static Point2D[] generateRandomPoint2Ds(int N) {
        StdDraw.setPenRadius(0.01);
        Point2D[] points = new Point2D[N];
        for (int i = 0; i < N; i++) {
            points[i] = new Point2D(StdRandom.uniform(), StdRandom.uniform());
            points[i].draw();
        }
        return points;
    }
}
