package fundamentals.stacksandqueues;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author firepond algs4 exercise 1.3.19
 */

public class LinkedList<Item> implements Iterable<Item> {

    private Node first;
    private int N = 0;

    private class Node {
        private Node next;
        private Item item;

        public String toString() {
            return "item:" + item + ", next: " + next;
        }
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void addFirst(Item item) {
        if (isEmpty()) {
            first = new Node();
            first.item = item;
        } else {
            Node oldFirst = first;
            first = new Node();
            first.next = oldFirst;
            first.item = item;
        }
        N++;
    }

    public void addLast(Item item) {
        if (isEmpty()) {
            first = new Node();
            first.item = item;
        } else {
            Node current = first;
            while (current.next != null) {
                current = current.next;
            }
            Node last = new Node();
            current.next = last;
            last.item = item;
        }
        N++;
    }

    public void deleteFirst() {
        if (!isEmpty()) {
            first = first.next;
            N--;
        }
    }

    public void deleteLast() {
        if (isEmpty()) {
            return;
        }

        if (N == 1) {
            first = null;
        }

        Node current = first;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
        N--;
    }

    public void delete(int k) {
        if (k < 1 || k > N) {
            return;
        }
        if (k == 1) {
            first = first.next;
            N--;
            return;
        }
        Node current = first;
        for (int i = 0; i < k - 2; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        N--;
    }

    public boolean find(Item key) {
        if (isEmpty()) {
            return false;
        }
        Node current = first;
        boolean isFound = false;
        while (current != null) {
            if (current.item.equals(key)) {
                isFound = true;
                break;
            }
            current = current.next;
        }
        return isFound;
    }

    public void removeAfter(Node nd) {
        if (nd == null || nd.next == null)
            return;
        if (nd.next.next == null) {
            nd.next = null;
            N--;
        } else { // the node after nd is not last node
            nd.next = nd.next.next;
            N--;
        }
    }

    public void insertAfter(Node a, Node b) {
        if (a != null && b != null) {
            Node oldNext = a.next;
            a.next = b;
            b.next = oldNext;
            N++;
        }
    }

    private void removeHead(Item key) {
        while (first.item.equals(key)) {
            if (first.next != null) {
                first = first.next;
                N--;
            } else {
                first = null;
                N--;
                return;
            }
        }
    }

    private void removeBody(Item key) {
        if (first.next != null) {
            Node current = first.next;
            Node previous = first;
            while (current.next != null) {
                if (current.item.equals(key)) {
                    previous.next = current.next;
                    current.next = null;
                    current = previous.next;
                    N--;
                } else {
                    previous = current;
                    current = current.next;
                }
            }
            if (current.item.equals(key)) {
                previous.next = null;
                N--;
            }
        }
    }

    public void remove(LinkedList<Item> list, Item key) {
        list.removeHead(key);
        if (!list.isEmpty()) {
            list.removeBody(key);
        }
    }

    public Node removeNthFromEnd(Node head, int n) {
        Node slowNode = head;
        Node quickNode = head;
        for (int i = 1; i < n; i++) {
            quickNode = quickNode.next;
        }
        while (quickNode.next != null) {
            quickNode = quickNode.next;
            slowNode = slowNode.next;
        }
        if (slowNode.next != null) {
            slowNode.item = slowNode.next.item;
            slowNode.next = slowNode.next.next;
            return head;
        }
        return null;
    }

    public int max(Node head) {
        int max = 0;
        if (head != null) {
            Node current = head;
            while (current.next != null) {
                int c = (Integer) current.item;
                if (c > max) {
                    max = c;
                }
                current = current.next;

            }
            int c = (Integer) current.item;
            if (c > max) {
                max = c;
            }
        }

        return max;
    }

    public int maxRecursion(Node head) {
        int max = 0;
        if (head != null) {
            if (head.next != null) {
                max = maxRecursion(head.next);

            }
            int here = (Integer) head.item;
            if (here > max) {
                max = here;
            }
        }
        return max;
    }

    public Node reverse(Node head) {
        Node current = head;
        Node previous = null;
        while (current != null) {
            Node following = current.next;
            current.next = previous;
            previous = current;
            current = following;
        }
        first = previous;
        return previous;
    }

    public Node reverseRecursive(Node head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        Node following = head.next;
        head.next = null;
        Node reversedHead = reverseRecursive(following);
        following.next = head;
        first = reversedHead;
        return reversedHead;

    }

    public Node createNode(Item item) {
        Node node = new Node();
        node.item = item;
        return node;
    }

    public void printList() {
        StdOut.println(this);
    }

    public String toString() {
        String result = "[ ";
        for (Item x : this) {
            result += x + " -> ";
        }
        result = result.replaceFirst(" -> $", " ");
        return result + "]";
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return !(current == null);
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);

        linkedList.delete(1);
        StdOut.println(linkedList);

        StdOut.println("Before reverse list items: " + linkedList);
        StdOut.println("Expected: 1 2 3 4");

        linkedList.reverseRecursive(linkedList.first);

        StdOut.println("Reverse list items: " + linkedList);
        StdOut.println("Expected: 4 3 2 1");
    }
}
