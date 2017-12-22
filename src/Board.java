import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: Enmanuel Reyes
 * Date: 12/22/17
 * Time: 3:44 PM
 */
public class Board {
    int[][] blocks;
    Board parent;

    public Board(int[][] blocks) {
        this.blocks = Arrays.copyOf(blocks,blocks.length);
    }
    public Board(int[][] blocks, Board parent) {
        this(blocks);
        this.parent = parent;
    }

    public int dimension() {
        return blocks.length;
    }

    public int hamming() {
        return blocks.length;
    }                   // number of blocks out of place

    public int manhattan() {
        return blocks.length;
    }                 // sum of Manhattan distances between blocks and goal

    public boolean isGoal() {
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks.length; j++) {
                int number = blocks[i][j];
                if (number != getGoalNumber(i,j)) {
                    return false;
                }
            }
        }
        return true;
    }               // is this board the goal board?

    private int getGoalNumber(int row, int col) {
        if (row == blocks.length-1 && col == blocks.length -1) {
            return 0;
        }else {
            return row*3 + col+1;

        }
    }


    public Board twin() {
        return null;
    }                        // a board that is obtained by exchanging any pair of blocks

    public boolean equals(Object y) {
        return false;
    }             // does this board equal y?

    public Iterable<Board> neighbors() {
        ArrayList<Board> boards = new ArrayList<>();
        int emptyRowIdx = 0;
        int emptyColIdx = 0;
        outer:
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks.length; j++) {
                int number = blocks[i][j];
                if (number == 0) {
                    emptyRowIdx = i;
                    emptyColIdx = j;
                    break outer;
                }
            }
        }

        int[][] copy ;
        if (emptyRowIdx == 0 && emptyColIdx == 0) {
            copy = Arrays.copyOf(blocks,blocks.length);
            copy[emptyRowIdx][emptyColIdx] = copy[emptyRowIdx][emptyColIdx+1];
            copy[emptyRowIdx][emptyColIdx+1] = 0 ;
            boards.add(new Board(copy,this));

            copy = Arrays.copyOf(blocks,blocks.length);
            copy[emptyRowIdx][emptyColIdx] = copy[emptyRowIdx+1][emptyColIdx];
            copy[emptyRowIdx+1][emptyColIdx] = 0 ;
            boards.add(new Board(copy,this));
        }


        return null;
    }    // all neighboring boards

    public String toString() {
        return null;
    }

    public static void main(String[] args) {
    } // unit tests (not graded)

}
