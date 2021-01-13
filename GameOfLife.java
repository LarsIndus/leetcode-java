/*

Leetcode Problem 288: Game of Life (Medium)

According to Wikipedia's article:
"The Game of Life, also known simply as Life, is a cellular automaton devised by
the British mathematician John Horton Conway in 1970."

The board is made up of an m x n grid of cells, where each cell has an initial state:
live (represented by a 1) or dead (represented by a 0).
Each cell interacts with its eight neighbors (horizontal, vertical, diagonal)
using the following four rules (taken from the above Wikipedia article):

    1. Any live cell with fewer than two live neighbors dies as if caused by under-population.
    2. Any live cell with two or three live neighbors lives on to the next generation.
    3. Any live cell with more than three live neighbors dies, as if by over-population.
    4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

The next state is created by applying the above rules simultaneously to every cell
in the current state, where births and deaths occur simultaneously.
Given the current state of the m x n grid board, return the next state.

Complexity for first solution:
O(n * m) time and O(1) space where n x m is the board size.

*/

public class GameOfLife {

    // directions for checking the neighbors
    static int[][] directions = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    // Solution 1: My first approach
    public static void gameOfLife1(int[][] board) {
        /*
        Idea: Save original value and live neighboars at the same time:
        new value = old value * 10 + live neighbors
        --> old value = new value / 10; live neighbors = new value % 10
        (note that this works as the number of neighbors is at most 8 < 10)
        */
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = board[i][j] * 10 + countLiveNeighbors(board, i, j);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // decoding
                int original = board[i][j] / 10;
                int liveNeighbors = board[i][j] % 10;

                // update cells according to the rules
                if (original == 1) {
                    if (liveNeighbors < 2) {
                        board[i][j] = 0;
                    } else if (liveNeighbors <= 3) {
                        board[i][j] = 1;
                    } else {
                        board[i][j] = 0;
                    }
                } else if (original == 0) {
                    if (liveNeighbors == 3) {
                        board[i][j] = 1;
                    } else {
                        board[i][j] = 0;
                    }
                }
                
            }
        }
    }

    // Count live neighbors, but take into consideration
    // that some cells might have already been updated by this very method.
    public static int countLiveNeighbors(int[][] board, int i, int j) {
        int count = 0;

        for (int[] dir : directions) {
            int ii = i + dir[0];
            int jj = j + dir[1];
            if (ii >= 0 && ii < board.length && jj >= 0 && jj < board[i].length) {
                /* If the neighboring cell (di, dj) has already been modified,
                we need to take the integer part after dividing by 10.
                Cells that already have been modified are simply the ones
                that come before (i, j) if we go through the board row-wise. */
                boolean alreadyModified = ii * board.length + jj < i * board.length + j;
                int original = alreadyModified ? board[ii][jj] / 10 : board[ii][jj];
                count += original;
            }
        }

        return count;
    }

    /* Solution 2:

    https://leetcode.com/problems/game-of-life/discuss/73366/Clean-O(1)-space-O(mn)-time-Java-Solution

    There are four possible cases of transformations:

        - 1 -> 0 (Rule 1 & 3)
        - 1 -> 1 (Rule 2)
        - 0 -> 1 (Rule 4)
        - 0 -> 0 (remaining cases)

    Idea:
    Update the board by using four distinct "codes" for these cases,
    such that we can easily convert the codes into 0, 1 once we processed the whole board.
    We do so by assigning even numbers in the cases where the outcome should be 0
    and odd numbers where the outcome should be 1.
    Doing so, we can simply reduce modulo 2 in the end to get the updated values.
    Thus, use the following codes:

        - 1 -> 0 (Rule 1 & 3):        2
        - 1 -> 1 (Rule 2):            1 (leave it as is)
        - 0 -> 1 (Rule 4):            3
        - 0 -> 0 (remaining cases):   0 (leave it as is)

    */
    public static void gameOfLife2(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int live = 0;
                for (int[] dir : directions) {
                    int ii = i + dir[0];
                    int jj = j + dir[1];
                    if (ii < 0 || ii >= board.length || jj < 0 || jj >= board[0].length) {
                        continue;
                    }
                    if (board[ii][jj] == 1 || board[ii][jj] == 2) {
                        live++;
                    }
                }

                // Rule 1 & 3
                if (board[i][j] == 1 && (live < 2 || live > 3)) {
                    board[i][j] = 2;
                }

                // Rule 4
                if (board[i][j] == 0 && live == 3) {
                    board[i][j] = 3;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] %= 2;
            }
        }
    }

    public static void main(String[] args) {
        int[][] board = {
            {0, 1, 0},
            {0, 0, 1},
            {1, 1, 1},
            {0, 0, 0}
        };

        System.out.println("Before update:");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        gameOfLife1(board);

        System.out.println("\nAfter update:");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
