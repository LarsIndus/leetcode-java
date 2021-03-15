/*

Leetcode Problem 64: Minimum Path Sum (Medium)

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right,
which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Complexity for this solution:
O(nm) time and space (linear in grid size)
Can also modify the original grid to avoid using additional space.

*/

public class MinimumPathSum {
    
    /*
    DP approach:
    Set up a dp array of the same size as the grid, in which the value in each cell
    is the shortest path to the corresponding cell in the input grid.
    Fill this array recursively; the result is then in the bottom right corner.
    */
    public static int minPathSum(int[][] grid) {
        // initial check
        if (grid == null || grid.length == 0) {
            return 0;
        }

        // number of rows and columns
        int n = grid.length;
        int m = grid[0].length;

        // Set up dp array and initialize:
        int[][] dp = new int[n][m];
        dp[0][0] = grid[0][0];

        // First column: current cell value + shortest path to previous cell
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        // First row: current cell value + shortest path to previous cell
        for (int j = 1; j < m; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        
        // All other cells not in first row or column:
        // current cell value + minimum of shortest path to the cell above or to the left
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        // result is in the bottom right cell
        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };

        System.out.println(minPathSum(grid));
    }
}