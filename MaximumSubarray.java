/*

Leetcode Problem 53: Maximum Subarray (Easy)

Given an integer array nums, find the contiguous subarray (containing at least one number)
which has the largest sum and return its sum.

Complexity for this solution:
Solution 1: O(n) time and O(1) space
Solution 2: O(n) time and space

*/

public class MaximumSubarray {
    
    // Solution 1: Kadane's Algorithm
    // O(n) time and O(1) space
    public static int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = nums[0]; // current maximum
        int sum = nums[0]; // maximum sum of subarray up to index i (initialized for  = 0)

        for (int i = 1; i < nums.length; i++) {
            // Maximum sum up to index i, is either the last sum (up to i - 1) plus nums[i],
            // or nums[i] (if the last sum was negative).
            sum = Math.max(nums[i], sum + nums[i]);
            // update overall maximum
            max = Math.max(max, sum);
        }

        return max;
    }

    // Solution 2: dynamic programming (almost like solution 1, just with additional space)
    // O(n) time and space
    public static int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n]; // dp[i] is the maximum sum of a subarray containig nums[i] as last element
        dp[0] = nums[0];
        int max = dp[0];
        
        for (int i = 1; i < n; i++){
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }
        
        return max;
}

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray2(nums));
    }
}
