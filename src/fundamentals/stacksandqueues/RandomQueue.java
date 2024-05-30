package fundamentals.stacksandqueues;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;

/**
 * @author firepond algs4 exercise 1.3.35
 */

@SuppressWarnings("unchecked")
public class RandomQueue<Item> implements Iterable<Item> {

    private Item[] a = (Item[]) new Object[1];
    private int N = 0;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        if (N == a.length) {
            resize(2 * a.length);
        }
        a[N++] = item;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue underflow");
        }
        int r = StdRandom.uniform(N - 1);
        Item temp = a[r];
        a[r] = a[N - 1];
        a[N - 1] = null;
        N--;
        if (N > 0 && N == a.length / 4) {
            resize(a.length / 2);
        }
        return temp;
    }

    public Item sample() {
        if (isEmpty()) {
            throw new RuntimeException("Queue underflow");
        }
        int r = StdRandom.uniform(N - 1);
        return a[r];
    }

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
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
        return new RandomQueueIterator();
    }

    private class RandomQueueIterator implements Iterator<Item> {
        private int i = 0;
        Item[] iteratorArray;

        public RandomQueueIterator() {
            i = 0;
            iteratorArray = (Item[]) new Object[N];
            copyArray();
            shuffle();
        }

        public boolean hasNext() {
            return i < N;
        }

        public Item next() {
            return iteratorArray[i++];
        }

        public void remove() {

        }

        private void copyArray() {
            for (int i = 0; i < N; i++) {
                iteratorArray[i] = a[i];
            }
        }

        private void shuffle() {
            for (int i = 0; i < N; i++) {
                int r = i + StdRandom.uniform(N - i);
                Item temp = iteratorArray[i];
                iteratorArray[i] = iteratorArray[r];
                iteratorArray[r] = temp;
            }
        }
    }

    public static void main(String[] args) {
        RandomQueue<Integer> randomQueue = new RandomQueue<>();
        randomQueue.enqueue(1);
        randomQueue.enqueue(2);
        randomQueue.enqueue(3);
        randomQueue.enqueue(4);
        randomQueue.enqueue(5);
        randomQueue.enqueue(6);
        randomQueue.enqueue(7);
        randomQueue.enqueue(8);

        StdOut.println(randomQueue.sample());
        StdOut.println(randomQueue.sample());
        StdOut.println(randomQueue.sample());

        StdOut.print("Random bag items: ");

        StdOut.println(randomQueue);
        StdOut.println(randomQueue);
        StdOut.println(randomQueue);

        StdOut.println(randomQueue.dequeue());
        StdOut.println(randomQueue);
        StdOut.println(randomQueue.dequeue());
        StdOut.println(randomQueue);
        StdOut.println(randomQueue.dequeue());
        StdOut.println(randomQueue);

    }

}