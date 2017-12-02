import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Created by IntelliJ IDEA.
 * User: Enmanuel Reyes
 * Date: 11/28/17
 * Time: 2:52 PM
 */
public class Percolation {

    private final WeightedQuickUnionUF weightedQuickUnionUF;
    private final boolean[] open;
    private int openSites;
    private final int n;

    public Percolation(int n) {                // create n-by-n grid, with all sites blocked
        if (n <= 0) {
            throw new IllegalArgumentException("index out of range");
        }
        int num = (n * n) + 2;
        weightedQuickUnionUF = new WeightedQuickUnionUF(num);
        open = new boolean[num];
        this.n = n;
        open[0] = true;
        open[num - 1] = true;
    }

    public void open(int row, int col) { // open site (row, col) if it is not open already
        if (row <= 0 || row > n || col <= 0 || col > n) {
            throw new IllegalArgumentException("index out of range");
        }
        int pos = map2Dto1DIndexes(row, col);
        if (!open[pos]) openSites++;
        open[pos] = true;


        if (col > 1)
            if (open[pos - 1]) {
                weightedQuickUnionUF.union(pos, pos - 1);
            }

        if (col < n)
            if (open[pos + 1]) {
                weightedQuickUnionUF.union(pos, pos + 1);
            }

        int upPos = pos - n;
        int downPos = pos + n;
        if (upPos >= 1)
            if (open[upPos]) {
                weightedQuickUnionUF.union(pos, upPos);

            }
        if (downPos >= 1 && downPos <= n * n)
            if (open[downPos]) {
                weightedQuickUnionUF.union(pos, downPos);

            }


        if (row == 1) {
            weightedQuickUnionUF.union(pos, 0);

        }
        if (row == n) {
            weightedQuickUnionUF.union(pos, open.length - 1);

        }
    }

    private int map2Dto1DIndexes(int row, int col) {
        return ((row - 1) * n) + col;
    }

    public boolean isOpen(int row, int col) {
        if (row <= 0 || row > n || col <= 0 || col > n) {
            throw new IllegalArgumentException("index out of range");
        }
        int pos = map2Dto1DIndexes(row, col);
        return open[pos];
    }  // is site (row, col) open?

    public boolean isFull(int row, int col) {
        if (row <= 0 || row > n || col <= 0 || col > n) {
            throw new IllegalArgumentException("index out of range");
        }
        int pos = map2Dto1DIndexes(row, col);

        if (!open[pos]) return false;

        return weightedQuickUnionUF.connected(0, pos);
    } // is site (row, col) full?

    public int numberOfOpenSites() {
        return openSites;
    } // number of open sites

    public boolean percolates() {
        return weightedQuickUnionUF.connected(0, open.length - 1);
    } // does the system percolate?

    public static void main(String[] args) {

        Percolation p = new Percolation(6);
        p.open(1, 3);
        p.open(2, 3);
        p.open(3, 3);
        p.open(3, 1);
        System.out.println(p.isFull(3, 1));
    }
}
