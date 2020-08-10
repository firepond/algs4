package fundmentals.stacksandqueues;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;

/**
 * @author firepond algs4 exercise 1.3.15
 */

public class Exercise15 {

    public static void main(String[] args) {
        int k = 3;
        Queue<String> s;
        s = new Queue<String>();
        String filename = "test_data/1/3/15.txt";
        In in = new In(filename);
        while (!in.isEmpty()) {
            String item = in.readString();
            s.enqueue(item);
        }
        while (!s.isEmpty()) {
            s.dequeue();
            if (s.size() == k) {
                StdOut.println(s.dequeue());
                break;
            }
        }

    }

}
