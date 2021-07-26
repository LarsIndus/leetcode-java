/*

Leetcode Problem 172: Factorial Trailing Zeroes (Easy)

Given an integer n, return the number of trailing zeroes in n!.

Follow up: Could you write a solution that works in logarithmic time complexity?

Complexity for this solution:
O(log n) time (base 5) and O(1) space

*/

public class FactorialTrailingZeroes {

    // Solution 1: recursive
    public static int trailingZeroes1(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes1(n / 5);
    }

    // Solution 2: iterative
    public static int trailingZeroes2(int n) {
        int count = 0;
        while (n != 0) {
            /* int tmp = n / 5;
            count += tmp;
            n = tmp; */
            // shorter:
            n /= 5;
            count += n;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {0, 3, 5, 10, 25, 1000};
        for (int n : nums) {
            System.out.println(n + ": " + trailingZeroes1(n));
        }
    }
    
}