package fundamentals.unionfind;

import java.io.File;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class CanonicalWeightedUF {
    private int[] id;
    private int[] sz;
    private int[] max;
    private int count;

    public CanonicalWeightedUF(int n) {
        count = n;
        id = new int[n];
        max = new int[n];
        sz = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            sz[i] = 1;
            max[i] = i;
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

    /**
     * find the largest element in the connection component that contains i
     * 
     * @param i
     * @return the id of the largest element
     */
    public int find(int i) {

        return max[root(i)];
    }

    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);
        if (pRoot == qRoot) {
            return;
        }
        int maxRoot = max[p] >= max[q] ? max[p] : max[q];

        if (sz[pRoot] < sz[qRoot]) {
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
            max[qRoot] = maxRoot;
        } else {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
            max[pRoot] = maxRoot;
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
        CanonicalWeightedUF uf = new CanonicalWeightedUF(N);
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
        for (int i = 0; i < 10; i++) {
            StdOut.println(uf.find(i));
        }
    }

}
