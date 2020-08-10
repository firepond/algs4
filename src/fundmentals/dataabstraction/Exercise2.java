package fundmentals.dataabstraction;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Interval1D;

/**
 * @author firepond
 * algs4 exercise 1.2.2
 */

public class Exercise2 {

    public static void main(String[] args) {
        // int N = Integer.parseInt(args[0]);
        int N = 10;
        Interval1D[] intervals = generateRandomInterval1ds(N);
        printIntervalIntersections(intervals);

    }

    public static Interval1D[] generateRandomInterval1ds(int N) {
        Interval1D[] intervals = new Interval1D[N];
        for (int i = 0; i < N; i++) {
            double x = StdRandom.uniform();
            double y = StdRandom.uniform();
            if (x > y) {
                intervals[i] = new Interval1D(y, x);
            } else {
                intervals[i] = new Interval1D(x, y);
            }
        }
        return intervals;
    }

    public static void printIntervalIntersections(Interval1D[] intervals) {
        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[i].intersects(intervals[j])) {
                    StdOut.println("Interval " + intervals[i] + " intersect with interval" + intervals[j]);
                }
            }
        }

    }

}
