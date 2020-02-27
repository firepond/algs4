package stacksandqueues;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author firepond algs4 exercise 1.3.45
 */

public class StackGenerability {

    private static boolean willTheStackUnderflow(String[] inputValues) {
        int itemsCount = 0;

        for (String input : inputValues) {
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

    private static boolean canAPermutationBeGenerated(String[] permutation) {
        Stack<Integer> stack = new Stack<>();
        int current = 0;

        for (String value : permutation) {
            int integerValue = Integer.parseInt(value);

            if (stack.isEmpty() || integerValue > stack.peek()) {
                while (current < integerValue) {
                    stack.push(current);
                    current++;
                }

                current++;
            } else if (integerValue == stack.peek()) {
                stack.pop();
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        StdOut.println("Exercises makes perfect");

    }

}
