package fundmentals.stacksandqueues;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.In;

/**
 * @author firepond algs4 exercise 1.3.10
 */

public class InfixToPostfix {

    public static void main(String[] args) {
        String fileName = "test_data/1/3/10.txt";
        In in = new In(fileName);
        String input = in.readAll();
        String output = infixToPostfix(input);
        StdOut.print(output);

    }

    public static String infixToPostfix(String expression) {
        String[] compoments = expression.split(" ");
        Stack<String> vals = new Stack<String>();
        Stack<String> ops = new Stack<String>();
        for (String x : compoments) {
            if (x.equals("(")) {

            } else if (x.equals("+") || x.equals("-") || x.equals("*") || x.equals("/")) {
                ops.push(x);
            } else if (x.equals(")")) {
                String vr = vals.pop();
                String vl = vals.pop();
                String op = ops.pop();
                String infix = vl + " " + vr + " " + op;
                vals.push(infix);
            } else {
                vals.push(x);
            }
        }
        return vals.toString();
    }
}
