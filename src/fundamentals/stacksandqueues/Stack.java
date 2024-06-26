package fundamentals.stacksandqueues;

import java.util.Iterator;
import java.util.ConcurrentModificationException;

import edu.princeton.cs.algs4.StdOut;

public class Stack<Item> implements Iterable<Item> {
    private Node first;
    private int N;

    private int popCount;
    private int pushCount;

    private class Node {
        Item item;
        Node next;
    }

    public Stack() {

    }

    public Stack<Item> catenation(Stack<Item> a, Stack<Item> b) {
        Stack<Item> temp = new Stack<Item>();
        while (!a.isEmpty()) {
            temp.push(a.pop());
        }
        while (!b.isEmpty()) {
            temp.push(b.pop());
        }
        Stack<Item> result = new Stack<Item>();
        while (!temp.isEmpty()) {
            result.push(temp.pop());
        }
        return result;
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
        pushCount++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        popCount++;
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

        private int popStore = popCount;
        private int pushStore = pushCount;

        public boolean hasNext() {
            if (popCount != popStore || pushCount != pushStore) {
                throw new ConcurrentModificationException();
            }
            return current != null;
        }

        public Item next() {
            if (popCount != popStore || pushCount != pushStore) {
                throw new ConcurrentModificationException();
            }
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
