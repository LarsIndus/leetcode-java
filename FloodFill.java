/*

Leetcode Problem 733: Flood Fill (Easy)

An image is represented by a 2-D array of integers,
each integer representing the pixel value of the image (from 0 to 65535).

Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill,
and a pixel value newColor, "flood fill" the image.

To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally
to the starting pixel of the same color as the starting pixel,
plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel),
and so on. Replace the color of all of the aforementioned pixels with the newColor.

At the end, return the modified image.

Complexity for this solution:
O(nm) time and space (recursion!) where n x m is the size of the image (i.e., linear in image size).

*/

public class FloodFill {
    
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    // DFS approach
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // Initial check: If starting pixel already has the 'new' color, there is nothing to do.
        if (image[sr][sc] == newColor) {
            return image;
        }

        // fill the image by DFS
        int oldColor = image[sr][sc];
        dfs(image, sr, sc, oldColor, newColor);
        
        return image;
    }

    // helper method to perform DFS
    public static void dfs(int[][] image, int row, int col, int oldColor, int newColor) {
        int n = image.length;
        int m = image[0].length;

        // boundary and color check
        if (row < 0 || row >= n || col < 0 || col >= m || image[row][col] != oldColor) {
            return;
        }

        // new color
        image[row][col] = newColor;

        // continue with adjacent pixels
        for (int[] dir : directions) {
            dfs(image, row + dir[0], col + dir[1], oldColor, newColor);
        }

    }

    public static void main(String[] args) {
        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };

        int sr = 1;
        int sc = 1;
        int newColor = 2;
        int[][] newImage = floodFill(image, sr, sc, newColor);

        for (int[] row : newImage) {
            for (int k : row) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
    }
}