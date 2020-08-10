package fundmentals.dataabstraction;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author firepond algs4 exercise 1.2.16
 */

public class Rational {

    private final long numerator;
    private final long denominator;

    /**
     * @param numerator
     * @param denominator
     */
    public Rational(int numerator, int denominator) {
        if (denominator == 0)
            throw new RuntimeException("can't set denominator to zero");
        assert numerator < Integer.MAX_VALUE && numerator > Integer.MIN_VALUE : "numerator overflow";
        assert denominator < Integer.MAX_VALUE && denominator > Integer.MIN_VALUE : "denominator overflow";
        long gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
        this.numerator = numerator;
        this.denominator = denominator;
    }

    private Rational(long numerator, long denominator) {
        if (denominator == 0)
            throw new RuntimeException("can't set denominator to zero");
        long gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int numerator() {
        return (int) numerator;
    }

    public int denominator() {
        return (int) denominator;
    }

    public Rational plus(Rational b) {
        long numerator = this.numerator * b.denominator + b.numerator * this.denominator;
        long denominator = this.denominator * b.denominator;
        return new Rational(numerator, denominator);
    }

    public Rational minus(Rational b) {
        long numerator = this.numerator * b.denominator - b.numerator * this.denominator;
        long denominator = this.denominator * b.denominator;
        return new Rational(numerator, denominator);
    }

    public Rational times(Rational b) {
        long numerator = this.numerator * b.numerator;
        long denominator = this.denominator * b.denominator;
        return new Rational(numerator, denominator);
    }

    public Rational divides(Rational b) {
        long numerator = this.numerator * b.denominator;
        long denominator = this.denominator * b.numerator;
        return new Rational(numerator, denominator);
    }

    public boolean equals(Rational that) {
        return this.numerator == that.numerator && this.denominator == that.denominator;
    }

    public String toString() {
        return numerator + "/" + denominator;
    }

    private static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Rational a = new Rational(1, 2);
        Rational b = new Rational(1, 3);
        StdOut.println("a: " + a);
        StdOut.println("b: " + b);
        Rational c = a.plus(b);
        StdOut.println("c: " + c);
        Rational d = a.minus(b);
        StdOut.println("d: " + d);
        Rational e = a.times(b);
        StdOut.println("e: " + e);
        Rational f = a.divides(b);
        StdOut.println("f: " + f);
    }

}
