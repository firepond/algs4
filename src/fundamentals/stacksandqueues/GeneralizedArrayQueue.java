package fundamentals.stacksandqueues;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * @author firepond algs4 exercise 1.3.38
 */

@SuppressWarnings("unchecked")
public class GeneralizedArrayQueue<Item> implements Iterable<Item> {

    Item[] a = (Item[]) new Object[1];
    int head = 0;
    int tail = 0;
    int N = 0;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Item item) {
        if (N == a.length) {
            resize(2 * a.length);
        }
        a[tail++] = item;
        N++;
    }

    public Item delete(int k) {
        if (k < 1 || k > N) {
            throw new RuntimeException("No such element");
        }
        Item item = a[head];
        a[head + k - 1] = null;
        for (int i = head + k - 1; i < tail; i++) {
            a[i] = a[i + 1];
        }
        tail--;
        a[tail] = null;
        N--;
        if (N > 0 && N == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[head + i];
        }
        a = temp;
        head = 0;
        tail = N;
    }

    public String toString() {
        String result = "[ ";
        for (Item x : this) {
            result += x + ", ";
        }
        result = result.replaceFirst(", $", " ");
        return result + "]";
    }

    public Iterator<Item> iterator() {
        return new ResizingArrayQueueIterator();
    }

    private class ResizingArrayQueueIterator implements Iterator<Item> {

        private int i = head;

        public boolean hasNext() {
            return i < tail;
        }

        public Item next() {
            return a[i++];
        }

        public void remove() {

        }
    }

    public static void main(String[] args) {
        var s = new GeneralizedArrayQueue<Integer>();
        s.insert(1);
        s.insert(2);
        s.insert(3);

        StdOut.println(s);

        StdOut.println(s.delete(1));
        StdOut.println(s);

    }
}
