package stacksandqueues;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdOut;

public class Stack<Item> implements Iterable<Item> {
    private Node first;
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public Stack() {

    }

    public Stack(Stack<Item> s) {
        Stack<Item> temp = new Stack<Item>();
        for (Item x : s) {
            temp.push(x);
        }
        for (Item x : temp) {
            this.push(x);
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public Item peek() {
        return first.item;
    }

    public static Stack<String> copy(Stack<String> inputStack) {
        Stack<String> tempStack = new Stack<String>();
        Stack<String> newStack = new Stack<String>();
        for (String string : inputStack) {
            tempStack.push(string);
        }
        for (String string : tempStack) {
            newStack.push(string);
        }
        return newStack;

    }

    public String toString() {
        String result = "[ ";
        for (Item x : this) {
            result += x + ", ";
        }
        return result.replaceFirst(", $", " ]");
    }

    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Item> {
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

        Stack<Integer> q = new Stack<Integer>();
        q.push(1);
        q.push(2);
        q.push(3);
        StdOut.println(q);
        Stack<Integer> r = new Stack<Integer>(q);
        StdOut.println(r);
        q.pop();
        StdOut.println(q);
        StdOut.println(r);
        q.push(4);
        StdOut.println(q);
        StdOut.println(r);

    }

}
