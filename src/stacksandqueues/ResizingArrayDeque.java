package stacksandqueues;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * @author firepond algs4 exercise 1.3.33_2
 */

 
@SuppressWarnings("unchecked")
public class ResizingArrayDeque<Item> implements Iterable<Item> {
    private Item[] a = (Item[]) new Object[2];
    private int N = 0;
    private int first = 0;
    private int last = 1;

    public int length() {
        return a.length;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void pushLeft(Item item) {
        if (first == 0) {
            resize(N, 0);
        }
        a[first--] = item;
        N++;
    }

    public void pushRight(Item item) {
        if (last == a.length) {
            resize(0, N);
        }
        a[last++] = item;
        N++;
    }

    public Item popLeft() {
        if (isEmpty()) {
            return null;
        }
        Item item = a[++first];
        a[first] = null;
        N--;
        if (first > N) {
            resize(-first / 2, 0);
        }
        return item;
    }

    public Item popRight() {
        if (isEmpty()) {
            return null;
        }
        Item item = a[--last];
        a[last] = null;
        N--;
        if ((a.length - last) > N) {
            resize(0, (last - a.length) / 2);
        }
        return item;
    }

    private void resize(int left, int right) {
        int length = left + right + a.length;
        Item[] temp = (Item[]) new Object[length];
        for (int i = first; i < last; i++) {
            temp[i + left] = a[i];
        }
        a = temp;
        first += left;
        last += left;
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
        return new ResizingArrayDequeIterator();
    }

    private class ResizingArrayDequeIterator implements Iterator<Item> {

        private int i = first + 1;

        public boolean hasNext() {
            return i < last;
        }

        public Item next() {
            return a[i++];
        }

        public void remove() {

        }
    }

    public static void main(String[] args) {
        ResizingArrayDeque<Integer> resizingArrayDeque = new ResizingArrayDeque<Integer>();
        StdOut.println("Length:" + resizingArrayDeque.length());
        resizingArrayDeque.pushRight(0);
        StdOut.println("Length:" + resizingArrayDeque.length());
        resizingArrayDeque.pushRight(1);
        StdOut.println("Length:" + resizingArrayDeque.length());
        resizingArrayDeque.pushLeft(2);
        StdOut.println("Length:" + resizingArrayDeque.length());
        resizingArrayDeque.pushLeft(3);
        resizingArrayDeque.pushLeft(3);
        resizingArrayDeque.pushLeft(3);
        resizingArrayDeque.pushLeft(3);
        resizingArrayDeque.pushLeft(3);
        StdOut.println(resizingArrayDeque);
        StdOut.println(resizingArrayDeque.popLeft());
        StdOut.println("Length:" + resizingArrayDeque.length());
        StdOut.println(resizingArrayDeque.popRight());
        StdOut.println("Length:" + resizingArrayDeque.length());

    }

}
