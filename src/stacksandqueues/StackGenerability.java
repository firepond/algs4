package stacksandqueues;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author firepond 
 * algs4 exercise 1.3.45
 */

public class StackGenerability {

    private static boolean willTheStackUnderflow(String[] inputValues) {
        int itemsCount = 0;

        for(String input : inputValues) {
            if (input.equals("-")) {
                itemsCount--;
            } else {
                itemsCount++;
            }

            if (itemsCount < 0) {
                return true;
            }
        }

        return false;
    }

    


    public static void main(String[] args) {
        StdOut.println("Exercises makes perfect");

    }

}
