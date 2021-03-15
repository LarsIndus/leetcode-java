/*

Leetcode Problem 219: Contains Duplicate II (Easy)

Given an array of integers and an integer k, find out whether there are two distinct indices
i and j in the array such that nums[i] = nums[j]
and the absolute difference between i and j is at most k.

Complexity for this solution:
O(n) time and O(k) space

*/

import java.util.Set;
import java.util.HashSet;

public class ContainsDuplicateII {

    /* 
    Using a set with a sliding window:
    Put the numbers in a set, but once there would be more than k elements in the set,
    start deleting from the start.
    If a number cannot be added, that means it is already in the set,
    thus within a window of length k. Hence we return true in that case.
    */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++) {
            // This line makes sure the set has size <= k:
            if (i > k) set.remove(nums[i - k - 1]);
            // This line checks whether an element is already in the set,
            // thus in a window of length k.
            if (!set.add(nums[i])) return true;
        }

        // Saw only distinct elements with distance <= k.
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        System.out.println(containsNearbyDuplicate(nums, k));
    }
}