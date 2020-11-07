/*

Leetcode Problem 136: Single Number (Easy)

Given a non-empty array of integers nums, every element appears twice except for one.
Find that single one.

Follow up: Could you implement a solution with a linear runtime complexity and without using extra memory?

Complexity for this solution:
O(n) time and O(1) space (solution 1)

*/

import java.util.HashSet;

public class SingleNumber {
    
    // Solution 1: O(n) time and constant space
    public static int singleNumber1(int[] nums) {
        int result = 0;
        for (int n : nums) {
            result ^= n;
        }
        return result;
    }

    // Solution 2: O(n) time and space
    public static int singleNumber2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.contains(n)) set.remove(n);
            else set.add(n);
        }

        return set.iterator().next();
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 4, 5, 6, 4, 8, 6, 5}; // single element is 8
        System.out.println(singleNumber2(nums));
    }
}
