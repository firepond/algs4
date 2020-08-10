### ALGS4 Exercise 1.4.4



```java
public static int count(int[] a) {
    /*
    Block A
    */
    int n = a.length;
    int count = 0;
    for (int i = 0; /*Block B*/ i < n; i++)
        for (int j = i + 1; /*Block C*/ j < n; j++)
            if (a[i] + a[j] == 0)
                /*Block D*/
                count++;
                /*
                End of Block D
                */
            /*
            End of Block C
            */
        /*
        End of Block B
        */
    return count;
    /*
    End of Block A
    */
}
```

| statement | time in seconds | frequency | total time |
|:---:|:----:|:---:|:---:|
| D | $$t_0$$ | x (depend on input) |$$t_0x$$|
| C | $$t_1$$ |$$\frac{N^2}{2}-\frac{N}{2}$$|$$t_1(\frac{N^2}{2}-\frac{N}{2})$$|
| B | $$t_2$$ |N|$$t_2N$$|
| A | $$t_3$$ |1|$$t_3$$|
| whole program |  ||$$t_1(\frac{N^2}{2}-\frac{N}{2})+t_2N+t_3+t_0x$$|
| tilde approximation |  ||$$ \text{~}\frac{N^2}{2}$$|
| order of growth |  ||$$N^2$$|


