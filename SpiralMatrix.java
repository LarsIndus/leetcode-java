/*

Leetcode Problem 54: Spiral Matrix (Medium)

Given a matrix of m x n elements (m rows, n columns),
return all elements of the matrix in spiral order.

Complexity for this solution:
O(n) time and space with n being the number of elements in the matrix

*/

import java.util.List;
import java.util.ArrayList;

public class SpiralMatrix {
    
    // Solution 1: My first approach; linear time and space complexity
    public static List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> spiral = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return spiral;
        int n = matrix.length;
        int m = matrix[0].length;

        boolean[][] visited = new boolean[n][m];
        int i = 0;
        int j = 0;
        int nextRow;
        int nextCol;
        char direction = 'R';

        while (spiral.size() < n * m) {

            if (direction == 'R') {
                while (j < m && !visited[i][j]) {
                    spiral.add(matrix[i][j]);
                    visited[i][j] = true;
                    nextCol = Math.min(j + 1, m - 1);
                    if (!visited[i][nextCol]) {
                        j = nextCol;
                    }
                }
                direction = 'D';
                nextRow = Math.min(i + 1, n - 1);
                if (!visited[nextRow][j]) {
                    i = nextRow;
                }

            } else if (direction == 'D') {
                while (i < n && !visited[i][j]) {
                    spiral.add(matrix[i][j]);
                    visited[i][j] = true;
                    nextRow = Math.min(i + 1, n - 1);
                    if (!visited[nextRow][j]) {
                        i = nextRow;
                    }
                }
                direction = 'L';
                nextCol = Math.max(j - 1, 0);
                if (!visited[i][nextCol]) {
                    j = nextCol;
                }

            } else if (direction == 'L') {
                while (j >= 0 && !visited[i][j]) {
                    spiral.add(matrix[i][j]);
                    visited[i][j] = true;
                    nextCol = Math.max(j - 1, 0);
                    if (!visited[i][nextCol]) {
                        j = nextCol;
                    }
                }
                direction = 'U';
                nextRow = Math.max(i - 1, 0);
                if (!visited[nextRow][j]) {
                    i = nextRow;
                }

            } else if (direction == 'U') {
                while (i >= 0 && !visited[i][j]) {
                    spiral.add(matrix[i][j]);
                    visited[i][j] = true;
                    nextRow = Math.max(i - 1, 0);
                    if (!visited[nextRow][j]) {
                        i = nextRow;
                    }
                }
                direction = 'R';
                nextCol = Math.min(j + 1, m - 1);
                if (!visited[i][nextCol]) {
                    j = nextCol;
                }
            }
        }

        return spiral;
    }

    // Solution 2: shorter code, also linear time and space complexity
    public static List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> spiral = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return spiral;

        int size = matrix.length * matrix[0].length;
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;

        while (spiral.size() < size) {

            // moving right
            for (int j = left; j <= right && spiral.size() < size; j++) {
                spiral.add(matrix[top][j]);
            }
            top++;

            // moving down
            for (int i = top; i <= bottom && spiral.size() < size; i++) {
                spiral.add(matrix[i][right]);
            }
            right--;

            // moving left
            for (int j = right; j >= left && spiral.size() < size; j--) {
                spiral.add(matrix[bottom][j]);
            }
            bottom--;

            // moving up
            for (int i = bottom; i >= top && spiral.size() < size; i--) {
                spiral.add(matrix[i][left]);
            }
            left++;
        }

        return spiral;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        List<Integer> spiral = spiralOrder2(matrix);
        for (int i : spiral) {
            System.out.print(i + " ");
        }
    }

}
