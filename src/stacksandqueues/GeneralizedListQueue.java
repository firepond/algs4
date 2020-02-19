package stacksandqueues;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * @author firepond algs4 exercise 1.3.38
 */

public class GeneralizedListQueue<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void insert(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        N++;
    }

    public Item delete(int k) {
        if (k < 1 || k > N) {
            throw new RuntimeException("No such element");
        }
        if (k == 1) {
            Item item = first.item;
            first = first.next;
            N--;
            return item;
        }
        Node current = first;
        for (int i = 0; i < k - 2; i++) {
            current = current.next;
        }
        Item item = current.next.item;
        current.next = current.next.next;
        N--;
        if (isEmpty()) {
            last = null;
        }
        return item;
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
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {

        }
    }

    public static void main(String[] args) {
        var s = new GeneralizedListQueue<Integer>();
        s.insert(1);

        StdOut.println(s);

        StdOut.println(s.delete(1));
        StdOut.println(s);
    }

}