/*

Leetcode Problem 695: Max Area of Island (Medium)

Given a non-empty 2D array grid of 0's and 1's,
an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array.
(If there is no island, the maximum area is 0.)

Complexity for this solution:
O(nm) time (linear in size of the matrix)

*/

public class MaxAreaOfIsland {
    
    public static int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, DFS(grid, i, j));
                }
            }
        }

        return maxArea;
    }

    private static int DFS(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0) {
            return 0;
        }

        grid[i][j] = 0; // anything but 1
        int area = 1;
        area += DFS(grid, i - 1, j);
        area += DFS(grid, i + 1, j);
        area += DFS(grid, i, j - 1);
        area += DFS(grid, i, j + 1);

        return area;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {1, 1, 1, 1},
            {0, 1, 0, 0},
            {0, 0, 1, 0},
            {1, 1, 0, 0},
            {0, 0, 0, 1}
        };

        System.out.println(maxAreaOfIsland(grid));
    }
}
