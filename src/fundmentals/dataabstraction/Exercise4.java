package fundmentals.dataabstraction;

/**
 * @author firepond
 * algs4 exercise 1.2.4
 */

import edu.princeton.cs.algs4.StdOut;

public class Exercise4 {

    public static void main(String[] args) {
        String string1 = "hello";
        String string2 = string1;
        string1 = "world";
        StdOut.println(string1);
        StdOut.println(string2);

    }

}
