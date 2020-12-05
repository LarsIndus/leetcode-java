/*

Leetcode Problem 529: Minesweeper (Medium)

Let's play the minesweeper game (Wikipedia, online game)!

You are given a 2D char matrix representing the game board.
'M' represents an unrevealed mine, 'E' represents an unrevealed empty square,
'B' represents a revealed blank square that has no adjacent
(above, below, left, right, and all 4 diagonals) mines,
digit ('1' to '8') represents how many mines are adjacent to this revealed square,
and finally 'X' represents a revealed mine.

Now given the next click position (row and column indices)
among all the unrevealed squares ('M' or 'E'),
return the board after revealing this position according to the following rules:

    1. If a mine ('M') is revealed, then the game is over - change it to 'X'.
    2. If an empty square ('E') with no adjacent mines is revealed,
       then change it to revealed blank ('B') and all of its adjacent unrevealed squares
       should be revealed recursively.
    3. If an empty square ('E') with at least one adjacent mine is revealed,
       then change it to a digit ('1' to '8') representing the number of adjacent mines.
    4. Return the board when no more squares will be revealed.

Complexity for this solution:
O(boardsize) time and space

*/

import java.util.Queue;
import java.util.LinkedList;

public class Minesweeper {

    static int[][] directions = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static char[][] updateBoardDFS(char[][] board, int[] click) {
        int row = click[0];
        int col = click[1];
        
        if (board[row][col] == 'M') {
            board[row][col] = 'X';
        } else if (board[row][col] == 'E') {
            dfs(board, row, col);
        }

        return board;
    }

    public static boolean isValid(char[][] board, int i, int j) {
        return (i >= 0 && i < board.length && j >= 0 && j < board[i].length);
    }

    public static void dfs(char[][] board, int i, int j) {
        if (!isValid(board, i, j) || board[i][j] != 'E') {
            return;
        }

        int mines = 0;
        for (int[] dir : directions) {
            int row = i + dir[0];
            int col = j + dir[1];
            if (isValid(board, row, col) && (board[row][col] == 'M' || board[row][col] == 'X')) {
                mines++;
            }
        }

        if (mines > 0) {
            board[i][j] = (char)(mines + '0');
        } else {
            board[i][j] = 'B';
            for (int[] dir : directions) {
                dfs(board, i + dir[0], j + dir[1]);
            }
        }

    }

    public static char[][] updateBoardBFS(char[][] board, int[] click) {
        int row = click[0];
        int col = click[1];
        Queue<int[]> q = new LinkedList<>();
        
        if (board[row][col] == 'M') {
            board[row][col] = 'X';
        } else if (board[row][col] == 'E') {
            q.offer(new int[] {row, col});
        }

        while(!q.isEmpty()) {
            int[] pos = q.poll();
            int i = pos[0];
            int j = pos[1];

            int mines = 0;
            for (int[] dir : directions) {
                int ii = i + dir[0];
                int jj = j + dir[1];
                if (isValid(board, ii, jj) && (board[ii][jj] == 'M' || board[ii][jj] == 'X')) {
                    mines++;
                }
            }

            if (mines > 0) {
                board[i][j] = (char)(mines + '0');
            } else {
                board[i][j] = 'B';
                for (int[] dir : directions) {
                    int ii = i + dir[0];
                    int jj = j + dir[1];
                    if (isValid(board, ii, jj) && board[ii][jj] == 'E') {
                        q.offer(new int[] {ii, jj});
                    }
                }
            }
        }

        return board;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'E', 'E', 'E', 'E', 'E'},
            {'E', 'E', 'M', 'E', 'E'},
            {'E', 'E', 'E', 'E', 'E'},
            {'E', 'E', 'E', 'E', 'E'}

            /* {'B', '1', 'E', '1', 'B'},
            {'B', '1', 'M', '1', 'B'},
            {'B', '1', '1', '1', 'B'},
            {'B', 'B', 'B', 'B', 'B'}; */
        };

        int[] click = {0, 0};

        System.out.println("Before clicking:\n");
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }

        board = updateBoardBFS(board, click);

        System.out.println("\nAfter clicking:\n");
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
