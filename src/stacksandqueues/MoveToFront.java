package stacksandqueues;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author firepond 
 * algs4 exercise 1.3.40
 */

public class MoveToFront {
    LinkedList<Character> list;

    public MoveToFront() {
        list = new LinkedList<Character>();
    }

    public void addCharacter(char c) {
        if(list.isEmpty()) {
            list.addFirst(c);
        } else {
            if(list.find(c)) {
                list.remove(list, c);
                list.addFirst(c);
            } else {
                list.addFirst(c);
            }
        }
    }

    public String toString() {
        return list.toString();
    }

    public static void main(String[] args) {
        MoveToFront m = new MoveToFront();
        m.addCharacter('c');
        StdOut.println(m);
        m.addCharacter('d');
        StdOut.println(m);
        m.addCharacter('d');
        StdOut.println(m);
        m.addCharacter('c');
        StdOut.println(m);
        m.addCharacter('d');
        StdOut.println(m);

    }
}
