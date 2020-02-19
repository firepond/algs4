package stacksandqueues;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * @author firepond algs4 exercise 1.3.39
 */

@SuppressWarnings("unchecked")
public class RingBuffer<Item> implements Iterable<Item> {

    private Item[] a;
    private int N = 0;

    public RingBuffer(int N) {
        a = (Item[]) new Object[N];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        a[N++] = item;
    }

    public Item pop() {
        Item item = a[--N];
        a[N] = null;
        return item;
    }

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = N;

        public boolean hasNext() {
            return i > 0;
        }

        public Item next() {
            return a[--i];
        }

        public void remove() {

        }
    }

    public static void main(String[] args) {
        StdOut.println("Buffer");
    }

}