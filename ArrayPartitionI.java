/*

Leetcode Problem 561: Array Partition I (Easy)

Given an integer array nums of 2n integers, group these integers into n pairs
(a1, b1), (a2, b2), ..., (an, bn)
such that the sum of min(ai, bi) for all i is maximized.
Return the maximized sum.

Complexity for this solution:
O(n log n) time and O(1) space

*/

import java.util.Arrays;

public class ArrayPartitionI {
    
    // Sort the array and then just pair the values
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        // Sum up every other element, starting from the first one (the mins of the pairs)
        for (int i = 0; i < nums.length; i += 2) {
            result += nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {6, 2, 6, 5, 1, 2};
        System.out.println(arrayPairSum(nums));
    }
}