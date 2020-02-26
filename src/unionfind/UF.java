package unionfind;

import edu.princeton.cs.algs4.*;

public class UF {
    private int[] id;
    private int count;

    public UF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int count() {
        return count;
    }

    // public boolean connected(int p, int q) {
    //     return find(p)==find(q);
    // }

    // public int find(int p) {

    // }

    public void union(int p, int q) {

    }

    public static void main(String[] args) {
        String fileName = "";
        In in = new In(fileName);
        // int N = 
    }



}
