import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 * Created by IntelliJ IDEA.
 * User: Enmanuel Reyes
 * Date: 11/28/17
 * Time: 3:07 PM
 */
public class PercolationStats {

    private static final double CONFIDENCE_95 = 1.96;
    private final double mean;
    private final double stddev;
    private final int trials;

    public PercolationStats(int n, int trials) {  // perform trials independent experiments on an n-by-n grid
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException("index out of range");
        }

        this.trials = trials;

        double[] xs = new double[trials];


        for (int i = 0; i < trials; i++) {
            Percolation percolation = new Percolation(n);
            do {
                int row = StdRandom.uniform(n) + 1;
                int col = StdRandom.uniform(n) + 1;
                if (!percolation.isOpen(row, col)) {
                    percolation.open(row, col);
                }
            } while (!percolation.percolates());
            xs[i] = (double) percolation.numberOfOpenSites() / (n * n);
        }
        mean = StdStats.mean(xs);
        stddev = StdStats.stddev(xs);


    }

    public double mean() {
        return mean;
    }                         // sample mean of percolation threshold

    public double stddev() {
        return stddev;
    }                        // sample standard deviation of percolation threshold

    public double confidenceLo() {
        return mean() - (CONFIDENCE_95 * stddev()) / (Math.sqrt(trials));
    }             // low  endpoint of 95% confidence interval

    public double confidenceHi() {
        return mean() + (CONFIDENCE_95 * stddev()) / (Math.sqrt(trials));
    }  // high endpoint of 95% confidence interval

    public static void main(String[] args) {     // test client (described below)
        int x = StdIn.readInt();
        int y = StdIn.readInt();
        PercolationStats percolationStats = new PercolationStats(x, y);
        System.out.println("mean \t\t\t\t\t\t= " + percolationStats.mean());
        System.out.println("stddev \t\t\t\t\t\t= " + percolationStats.stddev());
        System.out.println("95% confidence interval \t= [" + percolationStats.confidenceLo() + ", " + percolationStats.confidenceHi() + "]");

    }
}
