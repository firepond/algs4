package fundmentals.programmingmodel;

import edu.princeton.cs.algs4.*;

public class Exercise7 {

    public static void main(String[] args) {
        partA();
        partB();
        partC();
    }

    public static void partA() {
        double t = 9.0;

        while (Math.abs(t - 9.0/t) > .001)
            t = (9.0/t + t) / 2.0;

        StdOut.printf("%.5f\n", t);
    }

    public static void partB() {
        int sum = 0;
		
		for (int i = 1; i < 1000; i++) {
			for (int j = 0; j < i; j++) {
				sum++;
			}
		}
		
		StdOut.println(sum);
    }

    public static void partC() {
        int sum = 0;
		
		for (int i = 1; i < 1000; i *= 2) {
			for (int j = 0; j < 1000; j++) {
				sum++;
			}
		}
		
		StdOut.println(sum);
    }

}