package sorting.elementarysorts;
import java.util.Random;

import edu.princeton.cs.algs4.StdOut;

public class Exercise12 extends Sort {

    @SuppressWarnings("rawtypes")
    public static void sort(Comparable[] a) {

        int N = a.length;

        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            int iCount = 0;
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && iCount++ >= 0 && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            System.out.printf("h:%8d  ", h);
            Double d = (double)iCount/ (double)N;
            System.out.printf("i:%8d \n", iCount);

            System.out.printf("i/N:%8f \n", d);

            h /= 3;
        }

    }

    public static void test(int power) {
        int N = 1;
        for (int i = 0; i < power; i++) {
            N *= 10;
        }
        StdOut.println("\nlength:" + N);

        Double[] a = new Double[N];
        Random r = new Random();
        for (int i = 0; i < N; i++) {
            a[i] = r.nextDouble();
        }
        sort(a);
    }

    public static void main(String[] args) {
        int max = 10;
        for (int i = 2; i <= max; i++) {
            test(i);
        }
    }
}