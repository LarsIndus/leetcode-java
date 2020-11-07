/*

Leetcode Problem 162: Find Peak Element (Medium)

A peak element is an element that is greater than its neighbors.
Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.

Follow up: Your solution should be in logarithmic complexity.

Complexity for this solution:
O(log n) time (binary search) and O(1) space

*/

public class FindPeakElement {

    public static int findPeakElement(int[] nums) {
        // do a binary search
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            // prevent overflow for very large arrays; don't do (left + right) / 2
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 3, 1};
        System.out.println(findPeakElement(nums));
    }
}
