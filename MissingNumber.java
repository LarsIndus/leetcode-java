/*

Leetcode Problem 268: Missing Number (Easy)

Given an array nums containing n distinct numbers in the range [0, n],
return the only number in the range that is missing from the array.

Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?

Complexity for this solution:
O(n) time and O(1) space

*/

import java.util.stream.*;

public class MissingNumber {

    // Solution 1: Math approach (my first solution)
    // might cause overflow for large n
    public static int missingNumber1(int[] nums) {
        int n = nums.length;
        int sum = IntStream.of(nums).sum();
        return n * (n + 1) / 2 - sum;
    }

    /*
    Solution 2: XOR approach (my first solution)
    Explanation: Any number XOR with itself is 0,
    any number XOR with 0 is the number itself
    and XOR is commutative and associative.
    */
    public static int missingNumber2(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res ^= i;
            res^= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(missingNumber2(nums));
    }
}