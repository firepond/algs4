package strings;

import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;

public class Alphabet {

    private final char[] alphabet;

    private final int bitLength;

    private final int r;

    public Alphabet(String s) {
        alphabet = s.toCharArray();
        int c, l;
        c = 2;
        l = 1;
        r = alphabet.length;
        while (c < r) {
            c *= 2;
            l++;
        }
        bitLength = l;
    }

    char toChar(int index) {
        if (index >= r) {
            throw new ArrayIndexOutOfBoundsException("No such index");
        }
        return alphabet[index];
    }

    int toIndex(char c) {
        for (int i = 0; i < r; i++) {
            if (alphabet[i] == c) {
                return i;
            }
        }
        throw new NoSuchElementException("No such char");
    }

    boolean contains(char c) {
        for (int i = 0; i < r; i++) {
            if (alphabet[i] == c) {
                return true;
            }
        }
        return false;
    }

    int r() {
        return alphabet.length;
    }

    int lgR() {
        return bitLength;
    }

    // int[] toIndices(String s) {

    // }

    // String toChars(int[] indices) {

    // }

    public static void main(String[] args) {
        Alphabet hex = new Alphabet("0123456789abcdef");
        StdOut.println("alphabet length: " + hex.r());
        StdOut.println("bit length: " + hex.lgR());
        StdOut.println("contains: " + hex.contains('g'));
        StdOut.println("toIndex: " + hex.toIndex('a'));
        StdOut.println("toChar: " + hex.toChar(10));

    }

}
