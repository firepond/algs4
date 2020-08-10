package fundmentals.dataabstraction;

/**
 * @author firepond
 * algs4 exercise 1.2.10
 */

import edu.princeton.cs.algs4.StdDraw;

public class VisualCounter {

    private int count;
    private int totalOperations;

    private final int max;
    private final int N;

    public static void main(String[] args) {
        VisualCounter visualCounter = new VisualCounter(6, 4);
		
		visualCounter.increment();
		visualCounter.decrement();
		visualCounter.decrement();
		visualCounter.decrement();
		visualCounter.decrement();
		visualCounter.increment();
    }

    public void increment() {
        if (totalOperations < N && count < max) {
            count++;
            totalOperations++;
            plotCounter();
        }
    }

    public void decrement() {
        if (totalOperations < N && Math.abs(count) < max) {
            count--;
            totalOperations++;
            plotCounter();
        }
    }

    private void plotCounter() {
        StdDraw.point(totalOperations, count);
    }

    public VisualCounter(int N, int max) {
        this.N = N;
        this.max = max;
        StdDraw.setPenRadius(0.05);
        StdDraw.setXscale(0, N + 1);
        StdDraw.setYscale(-max - 3, max + 3);
    }
}
