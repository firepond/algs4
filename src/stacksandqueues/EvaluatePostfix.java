package stacksandqueues;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;

/**
 * @author firepond 
 * algs4 exercise 1.3.11
 */

public class EvaluatePostfix {
    public static void main(String[] args) {
        String fileName = "algs4/1/3/11.txt";
        In in = new In(fileName);
        String input = in.readAll();
        int output = evaluatePostfix(input);
        StdOut.print(output);

    }

    public static int evaluatePostfix(String expression) {
        String[] compoments = expression.split(" ");
        Stack<Integer> vals = new Stack<Integer>();
        for (String x : compoments) {

            if (x.equals("+") || x.equals("-") || x.equals("*") || x.equals("/")) {
                int vr = vals.pop();
                int vl = vals.pop();
                if (x.equals("+")) {
                    vals.push(vl + vr);
                } else if (x.equals("-")) {
                    vals.push(vl - vr);
                } else if (x.equals("*")) {
                    vals.push(vl * vr);
                } else if (x.equals("/")) {
                    vals.push(vl / vr);
                }
            } else {
                vals.push(Integer.parseInt(x));
            }
        }
        return vals.pop();
    }
}
