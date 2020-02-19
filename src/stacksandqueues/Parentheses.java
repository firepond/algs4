package stacksandqueues;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author firepond algs4 exercise 1.3.4
 */

public class Parentheses {

    public static void main(String[] args) {
        Stack<Character> stack = new Stack<Character>();
        boolean isPaired = true;
        String file = "algs4/1/3/brackets.txt";
        In in = new In(file);
        while (in.hasNextChar()) {

            char next = in.readChar();
            if (next == '(' || next == '[' || next == '{') {
                stack.push(next);
            } else if (next == ')' || next == ']' || next == '}') {
                if (stack.isEmpty()) {
                    isPaired = false;
                    break;
                }
                char previous = stack.pop();
                if ((previous == '(' && next == ')') || (previous == '[' && next == ']')
                        || (previous == '{' && next == '}')) {
                    
                } else {
                    isPaired = false;
                    break;
                }
            }

        }

        StdOut.println(isPaired);

    }

    public static void funcName(int a) {

    }

}
