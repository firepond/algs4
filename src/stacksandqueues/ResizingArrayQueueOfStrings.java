package stacksandqueues;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;

/**
 * @author firepond algs4 exercise 1.3.14
 */

public class ResizingArrayQueueOfStrings {

    String[] a = new String[1];
    int head = 0;
    int tail = 0;
    int N = 0;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void enqueue(String item) {
        if (N == a.length) {
            resize(2 * a.length);
        }
        a[tail++] = item;
        N++;
    }

    public String dequeue() {
        if (this.isEmpty()) {
            throw new RuntimeException("Null queue");
        }
        String item = a[head];
        a[head] = null;
        head++;
        N--;
        if (N > 0 && N == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }

    private void resize(int max) {
        String[] temp = (String[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[head + i];
        }
        a = temp;
        head = 0;
        tail = N;
    }

    public static void main(String[] args) {
        ResizingArrayStack<String> s;
        s = new ResizingArrayStack<String>();
        String filename = "algs4-data/tobe.txt";
        In in = new In(filename);
        while (!in.isEmpty()) {
            String item = in.readString();
            if (!item.equals("-")) {
                s.push(item);
            } else if (!s.isEmpty()) {
                StdOut.print(s.pop() + " ");
            }
            StdOut.println("(" + s.size() + " left in queue)");
        }
    }
}
