package tools;

public class SelectionTest {
    int length;
    String[] strs;
    int bestMatchCount;
    int bestMatchString;

    public static int sort(char[] a) {
        int N = a.length;
        int count = 0;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (a[j] < a[min]) {
                    min = j;
                    count++;
                }
            }
            exch(a, i, min);
        }
        return count;
    }

    public static void exch(char[] a, int i, int j) {
        char t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public SelectionTest(int length) {
        this.length = length;
        char[] base = new char[length];
        for (int i = 0; i < length; i++) {
            base[i] = (char) ('a' + i);
        }
        String str = String.valueOf(base);
        this.strs = Pemutation.permuate(str);
        bestMatchCount = 0;
        bestMatchString = 0;
    }

    public void printBestMatch() {
        for (int i = 0; i < strs.length; i++) {
            test(i);
        }
        System.out.println(strs[bestMatchString]);
        System.out.println("Best count:" + bestMatchCount);
        System.out.println();
    }

    public int test(int j) {
        char[] a = strs[j].toCharArray();
        int count = sort(a);
        if (count > bestMatchCount) {
            bestMatchCount = count;
            bestMatchString = j;
        }
        return count;
    }

    public static int test(String j) {
        char[] a = j.toCharArray();
        int count = sort(a);
        System.out.println(j);
        System.out.println("Count:" + count);
        System.out.println();
        return count;
    }

    public static void main(String[] args) {
        // for (int i = 1; i < 13; i++) {
        // SelectionTest s = new SelectionTest(i);
        // s.printBestMatch();
        // }
        test("JIHGFEDCBA");
        test("FJIHGEDCBA");

    }

}