package fundamentals.stacksandqueues;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * @author firepond algs4 exercise 1.3.33_1
 */

public class Deque<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int N;

    private class Node {
        Item item;
        Node next;
        Node prev;

        public String toString() {
            return "item:" + item;
        }
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void pushLeft(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        if (isEmpty()) {
            last = first;
        } else {
            first.next = oldFirst;
            oldFirst.prev = first;
        }
        N++;
    }

    public void pushRight(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        if (isEmpty()) {
            first = last;
        } else {
            last.prev = oldLast;
            oldLast.next = last;
        }
        N++;
    }

    public Item popLeft() {
        if (isEmpty()) {
            return null;
        }
        Item ret = first.item;
        if (first.next == null) {
            last = null;
        } else {
            first.next.prev = null;
        }
        first = first.next;
        N--;
        return ret;
    }

    public Item popRight() {
        if (isEmpty()) {
            return null;
        }
        Item ret = last.item;
        if (last.prev == null) {
            first = null;
        } else {
            last.prev.next = null;
        }
        last = last.prev;
        N--;
        return ret;
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
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {
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
        Deque<Integer> deque = new Deque<Integer>();
        deque.pushRight(0);
        StdOut.println(deque.popRight());
        StdOut.println(deque);
        StdOut.println(deque.popRight());

    }

}
