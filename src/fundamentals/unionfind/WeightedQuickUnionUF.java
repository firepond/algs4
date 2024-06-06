package fundamentals.unionfind;

import java.io.File;

import edu.princeton.cs.algs4.*;

public class WeightedQuickUnionUF {
    private int[] id;
    private int[] sz;
    private int count;

    public WeightedQuickUnionUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            sz[i] = 1;
        }

    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    private int root(int p) {
        while (p != id[p]) {
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);
        if (pRoot == qRoot) {
            return;
        }

        if (sz[pRoot] < sz[qRoot]) {
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }

        count--;
    }

    public static void main(String[] args) {
        String parentPath = "algs4-data";
        // String fileName = "tinyUF.txt";
        String fileName = "largeUF.txt";
        File file = new File(parentPath, fileName);
        In in = new In(file);
        int N = in.readInt();
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
        int count = 0;
        while (!in.isEmpty()) {
            int p = in.readInt();
            int q = in.readInt();
            if (uf.connected(p, q)) {
                continue;
            }
            uf.union(p, q);
            // StdOut.println(p + " " + q);

            count++;
            if (count % 1000 == 0) {
                StdOut.println("" + count + " / " + N);
            }
        }
        StdOut.println(uf.count() + " components");
    }

}