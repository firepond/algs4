package stacksandqueues;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;

/**
 * @author firepond algs4 exercise 1.3.34
 */

@SuppressWarnings("unchecked")
public class RandomBag<Item> implements Iterable<Item> {

    private Item[] a = (Item[]) new Object[1];
    private int N = 0;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void add(Item item) {
        if (N == a.length) {
            resize(2 * a.length);
        }
        a[N++] = item;
    }

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public void shuffle() {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int r = i + StdRandom.uniform(N - i);
            Item temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
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
        shuffle();
        return new RandomBagIterator();
    }

    private class RandomBagIterator implements Iterator<Item> {
        private int i = 0;

        public boolean hasNext() {
            return i < N;
        }

        public Item next() {
            return a[i++];
        }

        public void remove() {

        }
    }

    public static void main(String[] args) {
        RandomBag<Integer> randomBag = new RandomBag<>();
        randomBag.add(1);
        randomBag.add(2);
        randomBag.add(3);
        randomBag.add(4);
        randomBag.add(5);
        randomBag.add(6);
        randomBag.add(7);
        randomBag.add(8);

        StdOut.print("Random bag items: ");

        StdOut.println(randomBag);
        StdOut.println(randomBag);
        StdOut.println(randomBag);
    }

}