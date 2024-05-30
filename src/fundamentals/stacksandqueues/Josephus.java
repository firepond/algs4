package fundamentals.stacksandqueues;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author firepond algs4 exercise 1.3.37
 */

public class Josephus {

    public static void main(String[] args) {
        int N = 7;
        int M = 2;
        var queue = new Queue<Integer>();
        for (int i = 1; i <= N; i++) {
            queue.enqueue(i);
        }
        int count = 0;
        while (queue.size() > 1) {
            int temp = queue.dequeue();
            count++;
            if (count == M) {
                StdOut.println(temp + " dead");
                count = 0;
            } else {
                queue.enqueue(temp);
            }
        }
        StdOut.println("The location is :" + queue.dequeue());
    }

}
