import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**

 * Created by IntelliJ IDEA.
 * User: Enmanuel Reyes
 * Date: 11/28/17
 * Time: 2:52 PM
 */
public class Percolation {

    WeightedQuickUnionUF weightedQuickUnionUF;
    int open[];
    public Percolation(int n) {                // create n-by-n grid, with all sites blocked
        int num = (n*n) +2;
        weightedQuickUnionUF = new WeightedQuickUnionUF(num);
        open = new int[num];
    }

    public    void open(int row, int col)  { // open site (row, col) if it is not open already
    }
    public boolean isOpen(int row, int col){
        return false;
    }  // is site (row, col) open?
    public boolean isFull(int row, int col) {        return false;
    } // is site (row, col) full?
    public     int numberOfOpenSites()      {return 0;} // number of open sites
    public boolean percolates()             {        return false;
    } // does the system percolate?

    public static void main(String[] args) {

    }
}
