/*

Leetcode Problem 200: Number of Islands (Medium)

Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.
An island is surrounded by water and is formed
by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.

Complexity for this solution:
O(nm) time (linear in size of the matrix) and O(1) space

*/

public class NumberOfIslands {

    private static void dfs(char[][] grid, int i, int j) {

        // check boundaries and whether there is land
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0') {
            return;
        }
        
        grid[i][j] = '0'; // anything but '1'
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

    private static int getNumberOfIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        char[][] grid = {
            {'1', '1', '1', '1'},
            {'0', '1', '0', '0'},
            {'0' , '0', '1', '0'},
            {'1', '1', '0', '0'},
            {'0', '0', '0', '1'}
        };

        System.out.println(getNumberOfIslands(grid));
    }
}