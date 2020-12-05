/*

Leetcode Problem 1091: Shortest Path in Binary Matrix (Medium)

In an N by N square grid, each cell is either empty (0) or blocked (1).
A clear path from top-left to bottom-right has length k if and only if
it is composed of cells C_1, C_2, ..., C_k such that:

    - Adjacent cells C_i and C_{i+1} are connected 8-directionally
      (i.e., they are different and share an edge or corner)
    - C_1 is at location (0, 0) (i.e. has value grid[0][0])
    - C_k is at location (N-1, N-1) (i.e. has value grid[N-1][N-1])
    - If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0).

Return the length of the shortest such clear path from top-left to bottom-right.
If such a path does not exist, return -1.

Complexity for this solution (BFS version):
O(N^2) time and space with N being the number of rows/columns (linear in matrix size)

*/

import java.util.Queue;
import java.util.LinkedList;

public class ShortestPathInBinaryMatrix {

    static int[][] directions = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    // BFS solution, much more efficient than DFS to find the shortest path
    // put grid positions (i, j) into a queue by converting them to integers i * N + j
    public static int shortestPathBinaryMatrixBFS(int[][] grid) {
        int N = grid.length;
        if (grid[0][0] == 1 || grid[N - 1][N - 1] == 1) { // if starting/ending point blocked
            return -1;
        }

        // set up a queue and put the first position into it
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        // Search as long as there are positions in the queue;
        // increase steps one per round of search.
        for (int steps = 1; !q.isEmpty(); steps++) {
            // in each iteration, check every element that has been put into the queue in the last iteration
            for (int size = q.size(); size > 0; size--) {

                // decoding: get position (x, y)
                // use peek first and then poll,
                // so that the element is removed from the queue only in the second step
                int x = q.peek() / N;
                int y = q.poll() % N;

                // found shortest path, return its length
                if (x == N - 1 && y == N - 1) {
                    return steps;
                }
                
                // traverse 8 neighbors of (x, y)
                for (int[] dir : directions) {
                    int i = x + dir[0];
                    int j = y + dir[1];
                    if (i >= 0 && i < N && j >= 0 && j < N && grid[i][j] == 0) {
                        q.offer(i * N + j); // add it into queue if it is valid, and not blocked or visited.
                        grid[i][j] = -1; // mark as visited
                    }
                }

            }
        }

        // could not find a path, return -1
        return -1;
    }

    // DFS solution: not efficient, might lead to TLE
    public static int shortestPathBinaryMatrixDFS(int[][] grid) {
        int N = grid.length;
        if (grid[0][0] == 1 || grid[N - 1][N - 1] == 1) { // if starting/ending point blocked.
            return -1;
        }
        dfs(grid, 0, 0, 1);
        return grid[N - 1][N - 1] == 0 ? -1 : -grid[N - 1][N - 1];
    }

    public static void dfs(int[][] grid, int i, int j, int length) {
        int N = grid.length;

        if (i < 0 || i >= N || j < 0 || j >= N) return; // boundary check
        if (grid[i][j] == 1) return; // cell is blocked
        if (grid[i][j] != 0 && -grid[i][j] < length) return; // already found shorter path to this cell

        // save the negative length (to not confuse it with walls)
        // thus, we have to flip signs later when returning
        grid[i][j] = -length;

        for (int[] dir : directions) {
            dfs(grid, i + dir[0], j + dir[1], length + 1);
        }

    }

    public static void main(String[] args) {
        int[][] grid = {
            {0, 1, 0, 1, 0},
            {1, 0, 0, 0, 1},
            {0, 0, 1, 1, 1},
            {0, 0, 0, 0, 0},
            {1, 0, 1, 0, 0}
        };

        int length = shortestPathBinaryMatrixBFS(grid);

        for (int[] row : grid) {
            for (int n : row) {
                if (n < 0) {
                    System.out.print(" " + n);
                } else {
                    System.out.print("  " + n);
                }
            }
            System.out.println();
        }

        System.out.println("Shortest path has length " + length + ".");
    }

}
