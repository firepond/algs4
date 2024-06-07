package fundamentals;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
    public static void main(String[] args) {
        String champion = "";
        int count = 0;
        while (!StdIn.isEmpty()) {
            String cur = StdIn.readString();
            count++;
            boolean isNewChampion = StdRandom.bernoulli(1 / (double) count);
            if (isNewChampion) {
                champion = cur;
            }
            // StdOut.println("cur string: [" + cur + "]");
        }
        StdOut.println(champion);
    }

}
