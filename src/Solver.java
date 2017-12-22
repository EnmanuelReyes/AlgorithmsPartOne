import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by IntelliJ IDEA.
 * User: Enmanuel Reyes
 * Date: 12/22/17
 * Time: 3:49 PM
 */
public class Solver {

    MinPQ<Board> pq;
    private boolean solvable;

    public Solver(Board initial) {

    }           // find a solution to the initial board (using the A* algorithm)

    public boolean isSolvable() {
        return solvable;
    }
    private Board[] solution() {
        return new Board[0];
    }


    private String moves() {
        return null;
    }
    public static void main(String[] args) {
        // create initial board from file
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] blocks = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                blocks[i][j] = in.readInt();
        Board initial = new Board(blocks);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    } // solve a slider puzzle (given below)



}
