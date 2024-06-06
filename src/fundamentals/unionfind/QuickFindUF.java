package fundamentals.unionfind;

import java.io.File;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class QuickFindUF {

    private int[] id;
    private int count;

    QuickFindUF(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
        count = n;
    }

    /**
     * find if element p and element are connected
     * 
     * @param p
     * @param q
     * @return return true if p and q are connected
     */
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        if (pid == qid) {
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
        count--;
    }

    public int count() {
        return count;
    }

    public static void main(String[] args) {
        String parentPath = "algs4-data";
        // String fileName = "tinyUF.txt";
        String fileName = "mediumUF.txt";

        File file = new File(parentPath, fileName);
        In in = new In(file);
        int N = in.readInt();
        QuickFindUF uf = new QuickFindUF(N);

        while (!in.isEmpty()) {
            int p = in.readInt();
            int q = in.readInt();
            if (uf.connected(p, q)) {
                continue;
            }
            uf.union(p, q);
            // StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");

    }
}
