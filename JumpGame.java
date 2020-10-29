/*

Leetcode Problem 55: Jump Game (Medium)

Given an array of non-negative integers,
you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Determine if you are able to reach the last index.

Complexity for this solution:
O(n) time, O(1) space

*/

public class JumpGame {

    public static boolean canJump(int[] nums) {

        // Starting from the last index and going backwards,
        // check whether we can reach the next index.
        // If we get up to index 0 with this method, return true.
        int lastGoodIndex = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= lastGoodIndex) {
                lastGoodIndex = i;
            }
        }
        
        return lastGoodIndex == 0;
        
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(canJump(nums));
    }
}
