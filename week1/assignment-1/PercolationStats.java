/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private int T;
    private double[] fractions;

    /**
     * Performs T independent computational experiments on an N-by-N grid.
     */
    public PercolationStats(int N, int T) {
        if (N <= 0 || T <= 0) {
            throw new IllegalArgumentException();
        }

        this.T = T;
        this.fractions = new double[T];

        for (int i = 0; i < T; i++) {
            Percolation percolation = new Percolation(N);
            int nOpenSites = 0;

            while(!percolation.percolates()) {
                int row = StdRandom.uniform(1, N + 1);
                int column = StdRandom.uniform(1, N + 1);
                if (!percolation.isOpen(row, column)) {
                    percolation.open(row, column);
                    nOpenSites++;
                }
            }
            this.fractions[i] = (double) nOpenSites / (N * N);
        }
    }

    /**
     * Sample mean of percolation threshold.
     */
    public double mean() {
        return StdStats.mean(this.fractions);
    }

    /**
     * Sample standard deviation of percolation threshold.
     */
    public double stddev() {
        return StdStats.stddev(this.fractions);
    }

    /**
     * Returns lower bound of the 95% confidence interval.
     */
    public double confidenceLo() {
        return this.mean() - ((1.96 * this.stddev()) / Math.sqrt(this.T));
    }

    /**
     * Returns upper bound of the 95% confidence interval.
     */
    public double confidenceHi() {
        return this.mean() + ((1.96 * this.stddev()) / Math.sqrt(this.T));
    }

    public static void main(String[] args) {
        PercolationStats test = new PercolationStats(200, 100);
        System.out.println(test.mean());
        System.out.println(test.stddev());
        System.out.println(test.confidenceLo() + ", " + test.confidenceHi());
    }
}
