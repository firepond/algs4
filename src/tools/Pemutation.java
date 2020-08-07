package tools;

import java.util.Arrays;

public class Pemutation {

    public static String[] permuate(String a) {
        a = sortAndRemoveDuplicate(a);
        return permuate(a, "");
    }

    public static int getNumberOfPermutations(int N) {
        if (N == 0) {
            return 0;
        }
        int result = 1;
        for (int i = 1; i <= N; i++) {
            result *= i;
        }
        return result;
    }

    private static String[] permuate(String str, String prefix) {
        if (str.length() == 1) {
            return new String[] { prefix + str };
        }
        int N = str.length();
        String[] result = new String[getNumberOfPermutations(N)];
        for (int i = 0; i < N; i++) {
            String p = str.substring(i, i + 1);
            String subStr = str.substring(0, i) + str.substring(i + 1, N);
            String[] subResult = permuate(subStr, prefix + p);
            System.arraycopy(subResult, 0, result, i * subResult.length, subResult.length);
        }
        return result;

    }

    private static String sortAndRemoveDuplicate(String a) {
        int N = a.length();
        if (N == 0) {
            return a;
        }
        char[] c = a.toCharArray();
        Arrays.sort(c);
        char[] result = new char[N];
        int symbolCount = 1;
        char current = c[0];
        result[0] = c[0];
        for (int i = 1; i < N; i++) {
            if (c[i] != current) {
                current = c[i];
                result[symbolCount] = c[i];
                symbolCount++;
            }
        }
        result = Arrays.copyOf(result, symbolCount);
        return String.valueOf(result);

    }

    public static void main(String[] args) {
        String a = "abcd";
        String[] b = permuate(a);
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }
}