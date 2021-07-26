/*

Leetcode Problem 263: Ugly Number (Easy)

An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.

Given an integer n, return true if n is an ugly number.

Complexity for this solution:
O(log n) time and O(1) space

*/

public class UglyNumber {

    public static boolean isUgly(int n) {
        if (n <= 0) return false;

        while (n % 2 == 0) n /= 2;
        while (n % 3 == 0) n /= 3;
        while (n % 5 == 0) n /= 5;

        return n == 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 6, 14, 23, 30, 32, 500, 1000};
        for (int n : nums) {
            System.out.println(n + ": " + isUgly(n));
        }
    }
}