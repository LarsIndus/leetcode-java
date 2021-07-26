/*

Leetcode Problem 766: Toeplitz Matrix (Easy)

Given an m x n matrix, return true if the matrix is Toeplitz. Otherwise, return false.

A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same elements.

Complexity for this solution:
O(m*n) time and O(1) space

*/

public class ToeplitzMatrix {
    
    // Solution 1 (my initial approach; too laborious)
    public static boolean isToeplitzMatrix1(int[][] matrix) {
        if (matrix == null) return true;

        int n = matrix.length;
        int m = matrix[0].length;

        /* Check diagonals that start in the first column.
        Note that we do not have to check the last row,
        as this diagonal contains only one element (bottom-left element). */
        for (int i = 0; i < n - 1; i++) {
            int diagElement = matrix[i][0];
            // Diagonals starting in row i and first column.
            int row = i;
            int col = 0;
            // Move down diagonally while inside the bounds.
            while (row < n && col < m) {
                if (matrix[row++][col++] != diagElement) {
                    return false;
                }
            }
        }

        /* Check diagonals that start in the first row.
        Note that we do not have to check neither the first column
        (same diagonal as the one starting from the first row, which we checked above)
        nor the last column, as this diagonal contains only one element (top-right element). */
        for (int j = 1; j < m - 1; j++) {
            int diagElement = matrix[0][j];
            // Diagonals starting in first row column j.
            int row = 0;
            int col = j;
            // Move down diagonally while inside the bounds.
            while (row < n && col < m) {
                if (matrix[row++][col++] != diagElement) {
                    return false;
                }
            }
        }

        return true;
    }

    // Solution 2 (much shorter)
    public static boolean isToeplitzMatrix2(int[][] matrix) {
        if (matrix == null) return true;

        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1]) return false;
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 1, 2, 3},
            {9, 5, 1, 2}
        };

        System.out.println(isToeplitzMatrix1(matrix));
    }
}