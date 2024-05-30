package fundamentals.programmingmodel;

import edu.princeton.cs.algs4.*;

public class Exercise9 {

    public static void main(String[] args) {
        String b = intToBinaryString(1025);
        StdOut.println(b);

    }

    public static String intToBinaryString(int a) {
        StringBuffer s = new StringBuffer();
        while (a != 0) {
            s.insert(0, a % 2);
            a /= 2;
        }
        return s.toString();
    }

}