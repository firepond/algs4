package analysisofalgorithms;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.BinarySearch;

public class TwoSumFast {

    /**
     * Returns the number of triples (i, j, k) with {@code i < j < k} such that
     * {@code a[i] + a[j] + a[k] == 0}.
     *
     * @param a the array of integers
     * @return the number of triples (i, j, k) with {@code i < j < k} such that
     *         {@code a[i] + a[j] + a[k] == 0}
     */
    public static int count(int[] a) {
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (BinarySearch.indexOf(a, -a[i]) > i) {
                count++;
            }
        }
        return count;
    }

    /**
     * Reads in a sequence of integers from a file, specified as a command-line
     * argument; counts the number of triples sum to exactly zero; prints out the
     * time to perform the computation.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        String dataPath = "./algs4-data/";
        Out log = new Out("./log/TwoSumFast.txt");
        for (int i = 1; i <= 32; i *= 2) {
            String fileName = i + "Kints.txt";
            In in = new In(dataPath + fileName);
            int[] a = in.readAllInts();
            log.print(i + " ");
            StdOut.println(fileName);
            Stopwatch timer = new Stopwatch();
            int count = count(a);
            var time= timer.elapsedTime();
            StdOut.println("elapsed time = " + time);
            log.println(time);
            StdOut.println(count);
            in.close();
        }
        log.close();
    }
}