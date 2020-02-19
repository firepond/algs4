package stacksandqueues;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.In;

/**
 * @author firepond algs4 exercise 1.3.9
 */

public class Exercise9 {

    public static void main(String[] args) {
        String fileName = "algs4/1/3/9.txt";
        In in = new In(fileName);
        String input = in.readAll();
        String output = addLeftBracket(input);
        StdOut.print(output);

    }

    public static String addLeftBracket(String expression) {
        String[] compoments = expression.split(" ");
        Stack<String> vals = new Stack<String>();
        Stack<String> ops = new Stack<String>();
        for (String x : compoments) {
            if (x.equals("+") || x.equals("-") || x.equals("*") || x.equals("/")) {
                ops.push(x);
            } else if (x.equals(")")) {
                String vr = vals.pop();
                String vl = vals.pop();
                String op = ops.pop();
                String infix = "(" + " " + vl + " " + op + " " + vr + " " + ")";
                vals.push(infix);
            } else {
                vals.push(x);
            }
        }
        return vals.pop();
    }
}
