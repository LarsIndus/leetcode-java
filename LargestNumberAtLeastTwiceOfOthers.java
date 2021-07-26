/*

Leetcode Problem 747: Largest Number At Least Twice of Others (Easy)

In a given integer array nums, there is always exactly one largest element.

Find whether the largest element in the array is at least twice as much
as every other number in the array.

If it is, return the index of the largest element, otherwise return -1.

Note:

    1. nums will have a length in the range [1, 50].
    2. Every nums[i] will be an integer in the range [0, 99].

Complexity for this solution:
O(n) time and O(1 space)

*/

public class LargestNumberAtLeastTwiceOfOthers {
    
    public static int dominantIndex(int[] nums) {
        if (nums.length == 1) return 0;

        // Iterate through the array and keep track of the largest and second largest values' indices.
        int indexLargest = 0;
        int indexSecondLargest = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[indexLargest]) {
                indexSecondLargest = indexLargest;
                indexLargest = i;
            } else if (nums[i] > nums[indexSecondLargest]) {
                indexSecondLargest = i;
            }
        }

        return (nums[indexLargest] >= 2 * nums[indexSecondLargest]) ? indexLargest : -1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 6, 2};
        System.out.println(dominantIndex(nums));
    }
}