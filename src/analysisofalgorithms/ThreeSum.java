package analysisofalgorithms;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;

public class ThreeSum {

    public static int count(int[] a) {
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if ((long)a[i] + a[j] + a[k] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] test = {2147483647, 1, -2147483648};
        StdOut.println(count(test));
        String dataPath = "./algs4-data/";
        Out log = new Out("./log/ThreeSum.txt");
        for (int i = 1; i <= 32; i *= 2) {
            String fileName = i + "Kints.txt";
            In in = new In(dataPath + fileName);
            int[] a = in.readAllInts();
            log.print(i + " ");
            StdOut.println(fileName);
            Stopwatch timer = new Stopwatch();
            int count = count(a);
            var time = timer.elapsedTime();
            StdOut.println("elapsed time = " + time);
            log.println(time);
            StdOut.println(count);
            in.close();
        }
        log.close();
    }
}