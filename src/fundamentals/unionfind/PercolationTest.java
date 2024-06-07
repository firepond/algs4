package fundamentals.unionfind;

import edu.princeton.cs.algs4.StdRandom;

public class PercolationTest {

    // test of all blocked sites
    private static void blockTest(int dim) {
        Percolation pc = new Percolation(dim);
        assert (pc.percolates() == false);

        for (int r = 1; r <= dim; r++) {
            for (int c = 1; c <= dim; c++) {
                assert (pc.isOpen(r, c) == false);
                assert (pc.isFull(r, c) == false);
            }
        }
        assert (pc.numberOfOpenSites() == 0);
    }

    // test of all open sites
    private static void openTest(int dim) {
        Percolation pc = new Percolation(dim);
        assert (pc.percolates() == false);
        for (int r = 1; r <= dim; r++) {
            for (int c = 1; c <= dim; c++) {
                pc.open(r, c);
            }
        }
        for (int r = 1; r <= dim; r++) {
            for (int c = 1; c <= dim; c++) {
                assert (pc.isOpen(r, c));
                assert (pc.isFull(r, c));
            }
        }
        assert (pc.percolates());
        assert (pc.numberOfOpenSites() == dim * dim);
    }

    private static void colTest(int dim) {
        for (int i = 1; i <= dim; i++) {
            int targetCol = i;
            colTest(dim, targetCol);
        }
    }

    private static void colTest(int dim, int targetCol) {

        Percolation pc = new Percolation(dim);
        assert (pc.percolates() == false);
        for (int i = 1; i <= dim; i++) {
            assert (pc.percolates() == false);
            pc.open(i, targetCol);
            assert (pc.isOpen(i, targetCol));
            assert (pc.isFull(i, targetCol));
            if (i < dim) {
                assert (pc.isFull(i + 1, targetCol) == false);
            }
            for (int r = 1; r <= dim; r++) {
                for (int c = 1; c <= dim; c++) {
                    if (c != targetCol) {
                        assert (pc.isOpen(r, c) == false);
                        assert (pc.isFull(r, c) == false);
                    }
                }
            }
        }

        assert (pc.percolates() == true);
    }

    private static void colTestReverse(int dim) {

        Percolation pc = new Percolation(dim);
        assert (pc.percolates() == false);
        int targetCol = StdRandom.uniformInt(1, dim + 1);
        for (int i = dim; i >= 1; i--) {
            assert (pc.percolates() == false);
            pc.open(i, targetCol);
            assert (pc.isOpen(i, targetCol));
            if (i > 1) {
                assert (pc.isFull(i, targetCol) == false);
                assert (pc.isFull(i - 1, targetCol) == false);
            }

            for (int r = 1; r <= dim; r++) {
                for (int c = 1; c <= dim; c++) {
                    if (c != targetCol) {
                        assert (pc.isOpen(r, c) == false);
                        assert (pc.isFull(r, c) == false);
                    }
                }
            }
        }

        assert (pc.percolates() == true);
    }

    private static void rowTest(int dim) {

        Percolation pc = new Percolation(dim);
        assert (pc.percolates() == false);

        for (int row = 1; row <= dim; row++) {
            for (int col = 1; col <= dim; col++) {
                pc.open(row, col);
            }
            assert (pc.numberOfOpenSites() == row * dim);
            assert (pc.isFull(row, 1));
            assert (pc.isFull(row, dim));
            if (row < dim) {
                assert (pc.isFull(row + 1, 1) == false);
                assert (pc.isFull(row + 1, dim) == false);
            }
        }

        assert (pc.percolates() == true);

        Percolation pc2 = new Percolation(dim);
        assert (pc2.percolates() == false);

        for (int row = 1; row <= dim; row++) {
            for (int col = dim; col >= 1; col--) {
                pc2.open(row, col);
            }
            assert (pc2.numberOfOpenSites() == row * dim);
            assert (pc2.isFull(row, 1));
            assert (pc2.isFull(row, dim));
            if (row < dim) {
                assert (pc2.isFull(row + 1, 1) == false);
                assert (pc2.isFull(row + 1, dim) == false);
            }
        }

        assert (pc2.percolates() == true);
    }

    private static void diagonalTest(int dim) {

        Percolation pc = new Percolation(dim);
        assert (pc.percolates() == false);

        for (int i = 1; i <= dim; i++) {

            pc.open(i, i);

            assert (pc.numberOfOpenSites() == i);

            if (i != 1) {
                assert (pc.isFull(i, i) == false);
            } else {
                assert (pc.isFull(i, i) == true);
            }

            if (dim == 1) {
                assert (pc.percolates() == true);
            } else {
                assert (pc.percolates() == false);
            }
        }

        pc = new Percolation(dim);
        assert (pc.percolates() == false);

        for (int i = dim; i >= 1; i--) {

            pc.open(i, i);

            assert (pc.numberOfOpenSites() == (dim - i + 1));

            if (i != 1) {
                assert (pc.isFull(i, i) == false);
            } else {
                assert (pc.isFull(i, i) == true);
            }

            if (dim == 1) {
                assert (pc.percolates() == true);
            } else {
                assert (pc.percolates() == false);
            }
        }

        pc = new Percolation(dim);
        assert (pc.percolates() == false);

        for (int i = 1; i <= dim; i++) {

            pc.open(i, dim - i + 1);

            assert (pc.numberOfOpenSites() == i);

            if (i != 1) {
                assert (pc.isFull(i, dim - i + 1) == false);
            } else {
                assert (pc.isFull(i, dim - i + 1) == true);
            }

            if (dim == 1) {
                assert (pc.percolates() == true);
            } else {
                assert (pc.percolates() == false);
            }
        }

    }

    private static void backWashTest(int dim) {
        assert (dim >= 3);
        Percolation pc = new Percolation(dim);
        assert (pc.percolates() == false);
        for (int i = 1; i <= dim; i++) {
            assert (pc.percolates() == false);
            pc.open(i, 1);
        }
        pc.open(dim, dim);
        assert (pc.isFull(dim, 1));
        assert (pc.isFull(dim, dim) == false);

        assert (pc.percolates() == true);
    }

    // test client (optional)
    public static void main(String[] args) {
        backWashTest(3);
        for (int i = 1; i < 100; i++) {
            blockTest(i);
            colTest(i);
            openTest(i);
            colTestReverse(i);
            rowTest(i);
            diagonalTest(i);
        }
    }
}
