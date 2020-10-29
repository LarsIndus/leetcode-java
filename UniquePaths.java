/*

Leetcode Problem 62: Unique Paths (Medium)

A robot is located at the top-left corner of a m x n grid.
The robot can only move either down or right at any point in time.
The robot is trying to reach the bottom-right corner of the grid.
How many possible unique paths are there?

Complexity for this solution:
...

*/

public class UniquePaths {
    public static int numberOfPaths(int n, int m) {
        // initialize a matrix filled with 1s
        int[][] mat = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = 1;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                mat[i][j] = mat[i - 1][j] + mat[i][j - 1];
            }
        }

        return mat[n - 1][m - 1];
    }

    public static void main(String[] args) {
        System.out.println(UniquePaths.numberOfPaths(3, 7));
    }
}
