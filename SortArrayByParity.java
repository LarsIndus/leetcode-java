/*

Leetcode Problem 905: Sort Array By Parity (Easy)

Given an array A of non-negative integers, return an array consisting of all the even elements of A,
followed by all the odd elements of A.

You may return any answer array that satisfies this condition.

Complexity for this solution:
O(n) time and O(1) space

*/

public class SortArrayByParity {
    
    // Solution 1
    public static int[] sortArrayByParity1(int[] A) {
        // index to place even numbers at
        int evenIndex = 0;
        for (int i = 0; i < A.length; i++) {
            // Whenever we encounter an even number, place it at the current index and increment index.
            if (A[i] % 2 == 0) {
                int temp = A[evenIndex];
                A[evenIndex++] = A[i];
                A[i] = temp;
            }
        }

        return A;
    }

    // Solution 2: two pointer approach
    public static int[] sortArrayByParity2(int[] A) {
        // pointers at start (for even numbers to be placed) and end (for odd numbers) of array
        int start = 0;
        int end = A.length - 1;
        while (start < end) {
            // move until start is at an odd and end at an even number --> then swap
            while (A[start] % 2 == 0  && start < end) start++;
            while (A[end] % 2 == 1 && start < end) end--;

            // swap even with odd
            int temp = A[start];
            A[start] = A[end];
            A[end] = temp;
        }

        return A;
    }

    public static void main(String[] args) {
        int[] A = {3, 1, 2, 4};
        for (int k : sortArrayByParity1(A)) {
            System.out.print(k + " ");
        }
    }
}