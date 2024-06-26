package fundamentals;

import edu.princeton.cs.algs4.StdOut;

public class HelloGoodbye {
    public static void main(String[] args) {
        if (args.length != 2) {
            StdOut.println("Errors");
            return;
        }
        // Hello Kevin and Bob.
        // Goodbye Bob and Kevin.
        StdOut.println("Hello " + args[0] + " and " + args[1] + ".");
        StdOut.println("Goodbye " + args[1] + " and " + args[0] + ".");
    }

}
