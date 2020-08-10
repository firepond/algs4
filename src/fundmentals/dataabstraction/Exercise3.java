package fundmentals.dataabstraction;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author firepond algs4 exercise 1.2.3
 */

public class Exercise3 {

    public static void main(String[] args) {
        int N = 6;
        double min = 0.35;
        double max = 0.72;

        Interval1D[][] interval1dPairs = new Interval1D[N][2];
        Interval2D[] interval2ds = new Interval2D[N];
        for (int i = 0; i < N; i++) {
            interval1dPairs[i][0] = generateRandomInterval1d(min, max);
            interval1dPairs[i][1] = generateRandomInterval1d(min, max);
            interval2ds[i] = new Interval2D(interval1dPairs[i][0], interval1dPairs[i][1]);
            interval2ds[i].draw();
        }
        int intersectCount = intserctCounts(interval2ds);
        StdOut.println("Intersect pairs: " + intersectCount);
        int containCount = containCounts(interval1dPairs);
        StdOut.println("Contain pairs: " + containCount);


    }

    public static Interval1D generateRandomInterval1d(double min, double max) {
        Interval1D interval1d;

        double x = StdRandom.uniform(min, max);
        double y = StdRandom.uniform(min, max);

        if (x > y) {
            interval1d = new Interval1D(y, x);
        } else {
            interval1d = new Interval1D(x, y);
        }

        return interval1d;
    }

    public static int intserctCounts(Interval2D[] interval2ds) {
        int count = 0;
        for (int i = 0; i < interval2ds.length; i++) {
            for (int j = i + 1; j < interval2ds.length; j++) {
                if (interval2ds[i].intersects(interval2ds[j])) {
                    count++;

                }
            }
        }
        return count;
    }

    public static int containCounts(Interval1D[][] interval1dPairs) {
        int count = 0;

        for (int i = 0; i < interval1dPairs.length; i++) {
            for (int j = i + 1; j < interval1dPairs.length; j++) {
                if (interval1dPairs[i][0].min() <= interval1dPairs[j][0].min()
                        && interval1dPairs[i][0].max() >= interval1dPairs[j][0].max()
                        && interval1dPairs[i][1].min() <= interval1dPairs[j][1].min()
                        && interval1dPairs[i][1].max() >= interval1dPairs[j][0].max()) {
                    count++;
                } else if (interval1dPairs[j][0].min() <= interval1dPairs[i][0].min()
                        && interval1dPairs[j][0].max() >= interval1dPairs[i][0].max()
                        && interval1dPairs[j][1].min() <= interval1dPairs[i][1].min()
                        && interval1dPairs[j][1].max() >= interval1dPairs[i][0].max()) {
                    count++;
                }

            }
        }

        return count;
    }

}
