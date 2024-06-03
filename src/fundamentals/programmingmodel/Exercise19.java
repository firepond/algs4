package fundamentals.programmingmodel;

import java.math.BigInteger;

/**
 * @author firepond
 * algs4 exercise 1.1.19
 */

import edu.princeton.cs.algs4.*;

public class Exercise19 {

    public static void main(String[] args) {
        int N = 10000;
        BigInteger[] fArray = FBigArray(N);
        for (int i = 0; i < N; i++) {
            StdOut.println(i + " " + fArray[i]);
        }
    }

    public static long F(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        return F(N - 1) + F(N - 2);
    }

    public static BigInteger FBig(BigInteger N) {
        if (N.equals(BigInteger.ZERO)) {
            return BigInteger.ZERO;
        }
        if (N.equals(BigInteger.ONE)) {
            return BigInteger.ONE;
        }
        BigInteger b1 = N.subtract(BigInteger.ONE);
        BigInteger b2 = N.subtract(BigInteger.TWO);
        BigInteger result = FBig(b1).add(FBig(b2));
        return result;
    }

    public static BigInteger[] FBigArray(int N) {
        BigInteger[] array = new BigInteger[N];
        array[0] = BigInteger.ZERO;
        array[1] = BigInteger.ONE;
        for (int i = 2; i < N; i++) {
            array[i] = array[i - 1].add(array[i - 2]);
        }
        return array;
    }
}
