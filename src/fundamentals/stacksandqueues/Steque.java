package fundamentals.stacksandqueues;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * @author firepond algs4 exercise 1.3.32
 */

public class Steque<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int N;

    private class Node {
        Item item;
        Node next;

        public String toString() {
            return "item:" + item + ", next: " + next;
        }
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
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

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        if (isEmpty()) {
            last = first;
        }
        N++;
    }

    public Item pop() {
        if (this.isEmpty()) {
            return null;
        }
        Item item = first.item;
        first = first.next;
        N--;
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
        return new StequeIterator();
    }

    private class StequeIterator implements Iterator<Item> {
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

        Steque<String> steque = new Steque<>();
        steque.push("Second Item");
        StdOut.println(steque.last);
        steque.enqueue("Third Item");
        StdOut.println(steque);
        StdOut.println(steque.pop());
        StdOut.println(steque);
        StdOut.println(steque.pop());
        StdOut.println(steque);
        StdOut.println(steque.pop());

    }

}
