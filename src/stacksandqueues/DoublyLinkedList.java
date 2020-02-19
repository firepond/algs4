package stacksandqueues;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * @author firepond algs4 exercise 1.3.31
 */

public class DoublyLinkedList<Item> implements Iterable<Item> {

    private DoubleNode<Item> first;
    private DoubleNode<Item> last;

    static class DoubleNode<Item> {
        private Item item;
        private DoubleNode<Item> next;
        private DoubleNode<Item> prev;

        private DoubleNode<Item> insertBefore(Item item) {
            DoubleNode<Item> before = new DoubleNode<Item>();
            before.item = item;
            before.next = this;
            before.prev = this.prev;
            this.prev = before;
            if (before.prev != null) {
                before.prev.next = before;
            }
            return before;
        }

        private DoubleNode<Item> insertAfter(Item item) {
            DoubleNode<Item> after = new DoubleNode<Item>();
            after.item = item;
            after.prev = this;
            after.next = this.next;
            this.next = after;
            if (after.next != null) {
                after.next.prev = after;
            }
            return after;
        }

        private Item remove() {
            Item ret = item;
            if (next != null) {
                next.prev = prev;
            }
            if (prev != null) {
                prev.next = next;
            }
            item = null;
            prev = null;
            next = null;
            return ret;
        }

        public String toString() {
            return item + " -> " + next;
        }

    }

    public static <Item> void insertFirst(Item item, DoublyLinkedList<Item> list) {
        if (list.first != null) {
            list.first = list.first.insertBefore(item);
        } else {
            list.first = new DoubleNode<Item>();
            list.first.item = item;
            list.last = list.first;
        }
    }

    public static <Item> void insertLast(Item item, DoublyLinkedList<Item> list) {
        if (list.last != null) {
            list.last = list.last.insertAfter(item);
        } else {
            list.last = new DoubleNode<Item>();
            list.last.item = item;
            list.first = list.last;
        }

    }

    public static <Item> Item removeFirst(DoublyLinkedList<Item> list) {
        if (list.first == null) {
            return null;
        }
        if (list.first.next == null) {
            Item ret = list.first.remove();
            list.first = null;
            return ret;
        }
        list.first = list.first.next;
        Item ret = list.first.prev.remove();
        list.first.prev = null;
        return ret;
    }

    public static <Item> Item removeLast(DoublyLinkedList<Item> list) {
        if (list.last == null) {
            return null;
        }
        if (list.last.prev == null) {
            Item ret = list.last.remove();
            list.last = null;
            return ret;
        }
        list.last = list.last.prev;
        Item ret = list.last.next.remove();
        list.last.next = null;
        return ret;
    }

    public static <Item> Item remove(DoubleNode<Item> node) {
        Item item = node.remove();
        return item;
    }

    public static <Item> DoubleNode<Item> insertBefore(Item item, DoubleNode<Item> node) {
        if (node == null) {
            node = new DoubleNode<Item>();
            node.item = item;
            return node;
        }
        return node.insertBefore(item);
    }

    public static <Item> DoubleNode<Item> insertAfter(Item item, DoubleNode<Item> node) {
        if (node == null) {
            node = new DoubleNode<Item>();
            node.item = item;
            return node;
        }
        return node.insertAfter(item);
    }

    public boolean isEmpty() {
        return first == null;
    }

    public String toString() {
        String result = "[ null <- ";
        for (Item x : this) {
            result += x + " <-> ";
        }
        return result.replaceFirst(" <-> $", " -> null ]");
    }

    public Iterator<Item> iterator() {
        return new DoubleLinkedListIterator();
    }

    private class DoubleLinkedListIterator implements Iterator<Item> {
        private DoubleNode<Item> current = first;

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
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        DoublyLinkedList.insertLast(98, doublyLinkedList);
        DoublyLinkedList.removeFirst(doublyLinkedList);


        StdOut.println(doublyLinkedList);
        DoublyLinkedList.insertLast(98, doublyLinkedList);
        DoublyLinkedList.removeLast(doublyLinkedList);
        StdOut.println(doublyLinkedList);

    }
}
