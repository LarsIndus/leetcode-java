/*

Leetcode Problem 283: Move Zeroes (Easy)

Given an array nums, write a function to move all 0's to the end of it
while maintaining the relative order of the non-zero elements.

Note:

    1. You must do this in-place without making a copy of the array.
    2. Minimize the total number of operations.

Complexity for this solution:
O(n) time and O(1) space

*/

import java.util.Arrays;

public class MoveZeroes {
    
    /*
    Idea:
    Go through the array and count the number of zeroes along the way.
    Every time we encounter a non-zero element shift it to the left as many times
    as we have encountered zeroes so far.
    */
    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int numberOfZeroes = 0; 
        for (int i = 0; i < nums.length; i++) {
            // just count the zeroes if we see one
	        if (nums[i] == 0) {
                numberOfZeroes++; 
            }
            // non-zero element and we have already seen zeroes --> shift to the left
            else if (numberOfZeroes > 0) {
	            nums[i - numberOfZeroes] = nums[i];
	            nums[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
