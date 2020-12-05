/*

Leetcode Problem 130: Surrounded Regions (Medium)

Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
A region is captured by flipping all 'O's into 'X's in that surrounded region.

Surrounded regions shouldn’t be on the border,
which means that any 'O' on the border of the board are not flipped to 'X'.
Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'.
Two cells are connected if they are adjacent cells connected horizontally or vertically.

Complexity for this solution:
O(NM) time and space (linear in board size)

*/

import java.util.Queue;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.Iterator;

public class SurroundedRegions {

    static int[][] directions = {{- 1, 0}, {1, 0}, {0, -1}, {0, 1}};

    // DFS solution: time and space complexity linear in board size, i.e., O(NM) -----------------------------
    public static void solveDFS(char[][] board) {
        if (board == null || board.length < 3 || board[0].length < 3) {
            return;
        }

        int N = board.length;
        int M = board[0].length;

        // Look for 'O's on the boundary and run a DFS to find all regions that are connected to these 'O's.
        // All these 'O's will be marked with the special character '#' later on.
        for (int i = 0; i < N; i++) {
            if (board[i][0] == 'O') boundaryDFS(board, i, 0);
            if (board[i][M - 1] == 'O') boundaryDFS(board, i, M - 1);
        }

        for (int j = 0; j < M; j++) {
            if (board[0][j] == 'O') boundaryDFS(board, 0, j);
            if (board[N - 1][j] == 'O') boundaryDFS(board, N - 1, j);
        }

        // turn all remaining 'O's into 'X' as they can be captured
        // all other original 'O's have been marked with a special character and can now be changed to 'O's again
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }

    }

    public static void boundaryDFS(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != 'O') {
            return;
        }

        board[i][j] = '#';

        // run DFS on adjacent cells
        for (int[] dir : directions) {
            boundaryDFS(board, i + dir[0], j + dir[1]);
        }
    }


    // BFS approach ------------------------------------------------------------------------------
    public static void solveBFS1(char[][] board) {
        if (board == null || board.length < 3 || board[0].length < 3) {
            return;
        }

        int N = board.length;
        int M = board[0].length;
        Queue<Integer> q = new LinkedList<>(); // cells to process

        // Look for 'O's on the boundary and run a BFS to find all regions that are connected to these 'O's.
        // All these 'O's will be marked with the special character '#' later on.
        for (int i = 0; i < N; i++) {
            if (board[i][0] == 'O') q.offer(i * M);
            if (board[i][M - 1] == 'O') q.offer(i * M + M - 1);
        }

        for (int j = 0; j < M; j++) {
            if (board[0][j] == 'O') q.offer(j);
            if (board[N - 1][j] == 'O') q.offer((N - 1) * M + j);
        }

        while(!q.isEmpty()) {
            int x = q.peek() / M;
            int y = q.poll() % M;
            board[x][y] = '#';

            // BFS on adjacent cells
            for (int[] dir : directions) {
                int row = x + dir[0];
                int col = y + dir[1];
                if (row >= 0 && row < N && col >= 0 && col < M && board[row][col] == 'O') {
                        q.offer(row * M + col);
                }
            }
        }

        // turn all remaining 'O's into 'X' as they can be captured
        // all other original 'O's have been marked with a special character and can now be changed to 'O's again
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }

    }


    // my first attempt (BFS) - not very elegant ---------------------------------------------------------
    public static void solveBFS2(char[][] board) {
        if (board == null || board.length < 3 || board[0].length < 3) {
            return;
        }

        int N = board.length;
        int M = board[0].length;
        Queue<Integer> q = new LinkedList<>(); // cells to process
        HashSet<Integer> seen = new HashSet<>(); // keep track of visited cells to mark them later

        // look for cells not on the boundaries that have an 'O'
        // put them into queue and hashset
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < M - 1; j++) {
                if (board[i][j] == 'O') {
                    q.offer(i * M + j);
                    seen.add(i * M + j);
                }

                while(!q.isEmpty()) {
                    // decoding
                    int x = q.peek() / M;
                    int y = q.poll() % M;
                    // If an 'O' is on the boundary, non of the cells visited in this iteration are captured.
                    // Thus, clear queue and set of visited points (so we don't mark them)
                    // and break out of the loop.
                    if (x == 0 || x == N - 1 || y == 0 || y == M - 1) {
                        q.clear();
                        seen.clear();
                        break;
                    }
        
                    // do a boundary check for adjacent cells
                    // if they contain an 'O' and haven't been visited in this iteration, add them to the queue
                    for (int[] dir : directions) {
                        int row = x + dir[0];
                        int col = y + dir[1];
                        if (row >= 0 && row < N && col >= 0 && col < M && board[row][col] == 'O' && seen.add(row * M + col)) {
                                q.offer(row * M + col);
                        }
                    }
                }

                // After processing the cells in the queue, mark all visited cells with an 'X' as they are captured.
                // Note: If cells cannot be captured, we break out of the while loop above and the set of
                // visited points will be empty, thus no cell will be marked here.
                Iterator<Integer> it = seen.iterator();
                    while(it.hasNext()) {
                        int temp = it.next();
                        board[temp / M][temp % M] = 'X';
                    }

            }
        }

    }


    public static void main(String[] args) {
        char[][] board = {
            {'O', 'O', 'X', 'X'},
            {'X', 'O', 'X', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'},
            {'X', 'X', 'X', 'X'},
        };

        System.out.println("Before solving:\n");
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }

        solveDFS(board);
        // solveBFS1(board);
        // solveBFS2(board);

        System.out.println("\nAfter solving:\n");
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}