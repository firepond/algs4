import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private WeightedQuickUnionUF union;
    private int dim;
    private boolean percolate;

    private int elementsCount;
    private int openSitesCount = 0;
    private boolean[] openSites;
    private boolean[] connectedTop;
    private boolean[] connectedBottom;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        dim = n;
        elementsCount = dim * dim;
        union = new WeightedQuickUnionUF(elementsCount);
        openSites = new boolean[elementsCount];
        connectedTop = new boolean[elementsCount];
        connectedBottom = new boolean[elementsCount];
    }

    private void validate(int p) {
        if (p <= 0 || p > dim) {
            throw new IllegalArgumentException("index " + p + " is not between 1 and " + dim);
        }
    }

    private int idx(int row, int col) {

        validate(col);
        validate(row);
        col -= 1;
        row -= 1;
        int idx = row * dim + col;
        return idx;
    }

    private void openNeighbor(int row, int col, int idx) {
        int adjacentIdx = idx(row, col);
        if (isOpen(adjacentIdx)) {
            int idxRoot = union.find(idx);
            int adjacentRoot = union.find(adjacentIdx);
            union.union(adjacentIdx, idx);

            if (connectedTop[idxRoot] || connectedTop[adjacentRoot]) {
                connectedTop[union.find(idx)] = true;
            }
            if (connectedBottom[idxRoot] || connectedBottom[adjacentRoot]) {
                connectedBottom[union.find(idx)] = true;
            }
        }
    }

    private boolean connectedTop(int idx) {
        return connectedTop[union.find(idx)];
    }

    private boolean connectedBottom(int idx) {
        return connectedBottom[union.find(idx)];
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {

        int idx = idx(row, col);
        if (isOpen(idx)) {
            return;
        }
        // not open, open it
        openSitesCount++;
        openSites[idx] = true;
        // upside
        if (row == 1) {
            // connect with virtual top row
            connectedTop[union.find(idx)] = true;
        }
        if (row == dim) {
            // virtual bottom row
            connectedBottom[union.find(idx)] = true;
        }

        if (row != 1) {
            openNeighbor(row - 1, col, idx);
        }

        // downside
        if (row != dim) {
            openNeighbor(row + 1, col, idx);
        }

        // left side
        if (col != 1) {
            openNeighbor(row, col - 1, idx);
        }

        // right side
        if (col != dim) {
            openNeighbor(row, col + 1, idx);
        }

        if (connectedTop(idx) && connectedBottom(idx)) {
            percolate = true;
        }

    }

    private boolean isOpen(int idx) {
        return openSites[idx];
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        int idx = idx(row, col);
        return isOpen(idx);
    }

    private boolean isFull(int idx) {
        return connectedTop(idx);
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        int idx = idx(row, col);
        return isFull(idx);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openSitesCount;
    }

    // does the system percolate?
    public boolean percolates() {
        return percolate;
    }

}