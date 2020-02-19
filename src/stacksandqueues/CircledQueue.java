package stacksandqueues;

import java.util.Iterator;
import java.util.StringJoiner;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author firepond algs4 exercise 1.3.29
 */

public class CircledQueue<Item> implements Iterable<Item> {
    private Node last;
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return last == null;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        if (isEmpty()) {
            last = new Node();
            last.next = last;
            last.item = item;
        } else {
            Node oldLast = last;
            last = new Node();
            last.item = item;
            last.next = oldLast.next;
            oldLast.next = last;
        }
        N++;

    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NullPointerException("Empty queue");
        }
        Item item = last.next.item;
        last.next = last.next.next;
        N--;
        if (isEmpty()) {

            last = null;
        }
        return item;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        int i = 0;
        private Node current = last.next;

        public boolean hasNext() {
            return i < N;
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            i++;
            return item;
        }

        public void remove() {

        }
    }

    public static void main(String[] args) {
        CircledQueue<Integer> queue = new CircledQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        StringJoiner queueItems = new StringJoiner(" ");
        for (int item : queue) {
            queueItems.add(String.valueOf(item));
        }

        StdOut.println("Queue items: " + queueItems.toString());
        StdOut.println("Expected: 1 2 3 4");
    }

}