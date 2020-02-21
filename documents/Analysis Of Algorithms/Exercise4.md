### ALGS4 Exercise 1.4.4

```java
public static int count(int[] a) {
    int n = a.length;
    int count = 0;
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            if (a[i] + a[j] == 0) {
                count++;
            }
        }
    }
    return count;
}
```

Statement | Time In Seconds | Frequency| Total Time
:---:|:----:|:---|:---
``count++;`` | t0 | x (depend on input) |t0 * x
 |  |  |
 |  |  |
 |  |  |


