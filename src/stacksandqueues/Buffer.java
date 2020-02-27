package stacksandqueues;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;

/**
 * @author firepond algs4 exercise 1.3.44
 */

public class Buffer {

    private Queue<Character> beforeCurosr;
    private Queue<Character> afterCursor;

    public Buffer() {
        beforeCurosr = new Queue<Character>();
        afterCursor = new Queue<Character>();
    }

    public void insert(char c) {
        beforeCurosr.enqueue(c);
    }

    public char delete() {
        return beforeCurosr.dequeue();
    }

    public void left(int k) {
        while (k > 0 && !beforeCurosr.isEmpty()) {
            char temp = beforeCurosr.dequeue();
            afterCursor.enqueue(temp);
            k--;
        }
    }

    public void right(int k) {
        while (k > 0 && !afterCursor.isEmpty()) {
            char temp = afterCursor.dequeue();
            beforeCurosr.enqueue(temp);
            k--;
        }
    }

    public int size() {
        return beforeCurosr.size() + afterCursor.size();
    }

    public String toString() {
        char[] result = new char[beforeCurosr.size() + afterCursor.size() + 1];
        result[beforeCurosr.size()] = '╬';
        int cursor = beforeCurosr.size();
        for (int i = cursor - 1; i >= 0; i--) {
            result[i] = beforeCurosr.dequeue();
        }
        for (int i = cursor + 1; i < result.length; i++) {
            result[i] = afterCursor.dequeue();
        }

        return new String(result);
    }

    public static void main(String[] args) {
        Buffer b = new Buffer();
        b.insert('c');
        b.insert('c');
        b.insert('c');
        b.insert('c');
        b.left(5);
        b.right(1);
        b.delete();
        b.insert('c');
        StdOut.println(b);
    }
}
