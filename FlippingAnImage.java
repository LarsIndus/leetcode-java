/*

Leetcode Problem 832: Flipping an Image (Easy)

Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.

To flip an image horizontally means that each row of the image is reversed.
For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].

To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.
For example, inverting [0, 1, 1] results in [1, 0, 0].

Complexity for this solution:
O(nm) time (linear in matrix size) and O(1) space
(only change original array --> method could as well be void ...)

*/

public class FlippingAnImage {

    public static int[][] flipAndInvertImage(int[][] A) {
        int n = A[0].length; // number of columns
        for (int[] row : A) {
            // Note that we only have to traverse columns until 2 * j < n
            // as we process two elements at a time.
            // Also note that if two elements that are to be flipped and inverted are different,
            // nothing would change, so we only do the operations if they are equal.
            // Also, in this case only inverting is required as the elements are the same.
            // Inverting is done by computing XOR with 1.
            for (int j = 0; 2 * j < n; j++) {
                if (row[j] == row[n - j - 1]) {
                    row[j] = row[n - j - 1] ^= 1;
                    // this is short for:
                    //A[i][j] ^= 1;
                    //A[i][cols - j - 1] = A[i][j];
                }
            }
        }

        return A;
    }

    public static void main(String[] args) {
        int[][] A = {
            {1, 1, 0},
            {1, 0, 1},
            {0, 0, 0}
        };

        System.out.println("Before flipping:");
        for (int[] row : A) {
            for (int k : row) {
                System.out.print(k + " ");
            }
            System.out.println();
        }

        flipAndInvertImage(A);

        System.out.println("\nAfter flipping:");
        for (int[] row : A) {
            for (int k : row) {
                System.out.print(k + " ");
            }
            System.out.println();
        }

    }
}