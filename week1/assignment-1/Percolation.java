/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private WeightedQuickUnionUF unionFind;
    private int N;
    private boolean[][] sites;
    private int top, bottom, nOpenSites;

    /**
     * Creates N-by-N grid, with all sites blocked.
     */
    public Percolation(int N) {
        if (this.N < 0) {
            throw new IllegalArgumentException();
        }

        this.sites = new boolean[N][N];
        this.unionFind = new WeightedQuickUnionUF(N * N + 2);
        this.N = N;
        this.top = 0;
        this.bottom = N * N + 1;
    }

    /**
     * Opens site (row i, column j) if it is not already.
     */
    public void open(int i, int j) {
        if (i <= 0 || i > this.N || j <= 0 || j > this.N) {
            throw new IllegalArgumentException();
        }

        this.sites[i - 1][j - 1] = true;

        this.nOpenSites += 1;

        // absolute bottom
        if (i == this.N) {
            this.unionFind.union(this.getQFIndex(i, j), this.bottom);

        }
        // absolute top
        if (i == 1) {
            this.unionFind.union(this.getQFIndex(i, j), this.top);
        }

        // bottom neighbor
        if (i < this.N && isOpen(i + 1, j)) {
            this.unionFind.union(this.getQFIndex(i, j), this.getQFIndex(i + 1, j));
        }
        // top neighbor
        if (i > 1 && isOpen(i - 1, j)) {
            this.unionFind.union(this.getQFIndex(i, j), this.getQFIndex(i - 1, j));
        }
        // left neighbor
        if (j > 1 && isOpen(i, j - 1)) {
            this.unionFind.union(this.getQFIndex(i, j), this.getQFIndex(i, j - 1));
        }
        // right neighbor
        if (j < this.N && isOpen(i, j + 1)) {
            this.unionFind.union(this.getQFIndex(i, j), this.getQFIndex(i, j + 1));
        }
    }

    /**
     * Is site (row i, column j) open?
     */
    public boolean isOpen(int i, int j) {
        if (i <= 0 || i > this.N || j <= 0 || j > this.N) {
            throw new IllegalArgumentException();
        }
        return this.sites[i - 1][j - 1];
    }

    /**
     * Is site (row i, column j) full?
     */
    public boolean isFull(int i, int j) {
        if (i <= 0 || i > this.N || j <= 0 || j > this.N) {
            throw new IllegalArgumentException();
        }
        return this.unionFind.connected(this.getQFIndex(i, j), this.top);
    }

    /**
     * Does the system percolate?
     */
    public boolean percolates() {
        return this.unionFind.connected(this.top, this.bottom);
    }

    public int numberOfOpenSites() {
        return this.nOpenSites;
    }

    /**
     * Return the index at site(i, j)
     *
     * @return index at site(i, j)
     */
    private int getQFIndex(int i, int j) {
        return this.N * (i - 1) + j;
    }
}
