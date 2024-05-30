package fundamentals.stacksandqueues;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * @author firepond
 *         algs4 exercise 1.3.48
 */

public class TwoStacksDeque<Item> implements Iterable<Item> {

    Deque<Item> deque;

    int aSize;
    int bSize;

    public TwoStacksDeque() {
        deque = new Deque<>();
    }

    public boolean isAEmpty() {
        return aSize == 0;
    }

    public boolean isBEmpty() {
        return bSize == 0;
    }

    public int aSize() {
        return aSize;
    }

    public int bSize() {
        return bSize;
    }

    public void pushA(Item item) {
        deque.pushLeft(item);
        aSize++;
    }

    public void pushB(Item item) {
        deque.pushRight(item);
        bSize++;
    }

    public Item popA() {
        if (isAEmpty()) {
            throw new RuntimeException("Stack A underflow");
        }

        aSize--;
        return deque.popLeft();
    }

    public Item popB() {
        if (isBEmpty()) {
            throw new RuntimeException("Stack B underflow");
        }

        bSize--;
        return deque.popRight();
    }

    @Override
    public Iterator<Item> iterator() {
        return new TwoStacksDequeIterator();
    }

    @SuppressWarnings("unchecked")
    private class TwoStacksDequeIterator implements Iterator<Item> {

        private int index;
        private Item[] items;
        private boolean hasNext;

        TwoStacksDequeIterator() {
            items = (Item[]) new Object[deque.size()];
            int currentIndex = 0;
            hasNext = true;

            for (Item item : deque) {
                items[currentIndex++] = item;
            }

            if (isAEmpty() && !isBEmpty()) {
                index = deque.size() - 1;
            }
        }

        @Override
        public boolean hasNext() {
            return hasNext;
        }

        @Override
        public Item next() {
            if (index == 0 && aSize() > 0) {
                StdOut.println("Stack 1");
            }
            if (index == deque.size() - 1 && bSize() > 0) {
                StdOut.println("Stack 2");
            }

            Item item = items[index];

            if (isIteratingStack1(index)) {
                if (index != aSize - 1) {
                    index++;
                } else if (!isBEmpty()) {
                    index = deque.size() - 1;
                } else {
                    hasNext = false;
                }
            } else {
                if (index != aSize) {
                    index--;
                } else {
                    hasNext = false;
                }
            }

            return item;
        }

        private boolean isIteratingStack1(int index) {
            return index < aSize;
        }
    }

    public static void main(String[] args) {
        StdOut.println("Exercises makes perfect");

    }

}
