| class | memory (bytes) |
|:-:|:-:|
| Accumulator | 40 |
| Transaction | 40 |
| FixedCapacityStackOfStrings | 48 + 8C + 8N |
| Point2D | 32 |
| Interval1D | 32 |
| Interval2D | 32 |
| Double | 24 |

% FixedCapacityStackOfStrings has capacity of C and N members


```java
public class Accumulator {
    private int n = 0;          // number of data values
    private double sum = 0.0;   // sample variance * (n-1)
    private double mu = 0.0;    // sample mean
}
// 4(int n) + 8 * 2(double sum, mu)+ 16(object) + 4(padding) = 40(bytes)
```

```java
public class Transaction {
    private final String  who;      // customer
    private final Date    when;     // date
    private final double  amount;   // amount
}

// 16(head) + 8(String who) + 8(Date when) + 8(double amount) = 40(bytes)
```

```java
public class FixedCapacityStackOfStrings {
    private String[] a;  // holds the items
    private int N;       // number of items in stack
}

// members in a[]: N * 40 = 40N(bytes)

// int[] a: 24(head) + 8 * C(reference) + 8N(members) = (24 + 8C + 8N)(bytes)

// Stack: 16(head) + (24 + 8C + 8N) + 4(int N) + 4(padding) = 48 + 8C + 8N(bytes)
```

```java
public final class Point2D implements Comparable<Point2D> {
    private final double x;    // x coordinate
    private final double y;    // y coordinate
}

// 16(object) + 8 * 2(double x, y) = 32(bytes)
```

```java
public class Interval1D {
    private final double min;
    private final double max;
}

// 16(object) + 8 * 2(double min, max) = 32(bytes);
```

```java
public class Interval2D {
    private final Interval1D x;
    private final Interval1D y;
}

// 16(object) + 2 * 8(Interval1D x, y) = 32(bytes)
```

```java
public final class Double extends Number implements Comparable<Double> {
    public static final double POSITIVE_INFINITY = 1.0 / 0.0;
    public static final double NEGATIVE_INFINITY = -1.0 / 0.0;
    public static final double NaN = 0.0d / 0.0;
    public static final double MIN_NORMAL = 0x1.0p-1022; 
    public static final double MIN_VALUE = 0x0.0000000000001P-1022; // 4.9e-324

    public static final int MAX_EXPONENT = 1023;
    public static final int MIN_EXPONENT = -1022;
    public static final int SIZE = 64;
    public static final int BYTES = SIZE / Byte.SIZE;
    public static final Class<Double> TYPE = (Class<Double>) Class.getPrimitiveClass("double");

    private final double value; 
} 

// 16(object) + 8(double value) = 24(btyes)
```


