/*

Leetcode Problem 941: Valid Mountain Array (Easy)

Given an array A of integers, return true if and only if it is a valid mountain array.

Recall that A is a mountain array if and only if:

    - A.length >= 3
    - There exists some i with 0 < i < A.length - 1 such that:
        - A[0] < A[1] < ... A[i-1] < A[i]
        - A[i] > A[i+1] > ... > A[A.length - 1]

Complexity for this solution:
O(n) time and O(1) space

*/

public class ValidMountainArray {

    // Solution 1: 
    public static boolean validMountainArray(int[] A) {
        int i = 0;
        while (i < A.length - 1 && A[i] < A[i + 1]) {
            i++;
        }

        if (i == 0 || i == A.length - 1) {
            return false;
        }

        while (i < A.length - 1) {
            if (A[i] <= A[i + 1]) {
                return false;
            }
            i++;
        }

        return true;
    }

    // Solution 2: "climb" mountain from both sides
    public static boolean validMountainArrayElegant(int[] A) {
        int n = A.length, i = 0, j = n - 1;
        while (i + 1 < n && A[i] < A[i + 1]) i++;
        while (j > 0 && A[j - 1] > A[j]) j--;
        return i > 0 && i == j && j < n - 1;
    }

    // Solution 3: My naive approach
    public static boolean validMountainArrayNaive(int[] A) {

        // find the first occurrence of the maximum
        int maxAt = 0;
        for (int i = 0; i < A.length; i++) {
            maxAt = A[i] > A[maxAt] ? i : maxAt;
        }

        // If maximum is at the edge, then not a valid mountain array.
        // Otherwise, it automatically follows that the length is at least 3.
        if (maxAt == 0 || maxAt == A.length - 1) {
            return false;
        }

        // check elements before the max
        for (int j = 0; j < maxAt - 1; j++) {
            if (A[j] >= A[j + 1]) {
                return false;
            }
        }

        // check elements after the max
        for (int k = maxAt; k < A.length - 1; k++) {
            if (A[k] <= A[k + 1]) {
                return false;
            }
        }

        // all checks successful
        return true;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 0};
        System.out.println(validMountainArray(A));
        System.out.println(validMountainArrayElegant(A));
        System.out.println(validMountainArrayNaive(A));
    }
    
}
