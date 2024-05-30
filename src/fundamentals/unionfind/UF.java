package fundamentals.unionfind;

import java.io.File;
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

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    // // quick-find start
    // public int find(int p) {
    // return id[p];
    // }

    // public void union(int p, int q) {
    // int pID = find(p);
    // int qID = find(q);

    // if (pID == qID) {
    // return;
    // }

    // for (int i = 0; i < id.length; i++) {
    // if (id[i] == pID) {
    // id[i] = qID;
    // }
    // }
    // count--;
    // }
    // // quick-find end

    // quick-union start

    private int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }

        id[pRoot] = qRoot;

        count--;
    }

    // quick-union end

    public static void main(String[] args) {
        String parnetPath = "algs4-data";
        String fileName = "tinyUF.txt";
        File file = new File(parnetPath, fileName);
        In in = new In(file);
        int N = in.readInt();
        UF uf = new UF(N);
        while (!in.isEmpty()) {
            int p = in.readInt();
            int q = in.readInt();
            if (uf.connected(p, q)) {
                continue;
            }
            uf.union(p, q);
            StdOut.println(p + " " + q);

        }
        StdOut.println(uf.count() + " components");
    }

}
