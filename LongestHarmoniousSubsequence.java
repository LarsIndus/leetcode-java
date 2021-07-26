/*

Leetcode Problem 594: Longest Harmonious Subsequence (Easy)

We define a harmonious array as an array where the difference between its maximum value
and its minimum value is exactly 1.

Given an integer array nums, return the length of its longest harmonious subsequence
among all its possible subsequences.

A subsequence of array is a sequence that can be derived from the array
by deleting some or no elements without changing the order of the remaining elements.

Complexity for this solution:
O(n) time and space

*/

import java.util.Map;
import java.util.HashMap;

public class LongestHarmoniousSubsequence {
    
    public static int findLHS(int[] nums) {
        // Count how often each number appears in the array.
        // Use long instead of int as we are going to check k + 1 later,
        // which might cause overflow is k is the maximum integer.
        Map<Long, Integer> map = new HashMap<>();
        for (long k : nums) {
            map.put(k, map.getOrDefault(k, 0) + 1);
        }

        int result = 0;

        // A harmonious subsequence consists of adjacent numbers.
        // Thus, for each integer k, check whether k + 1 also appeared.
        // The length of the longest harmonious subsequence is the sum of their values in the map.
        for (long k : map.keySet()) {
            if (map.containsKey(k + 1)) {
                result = Math.max(result, map.get(k) + map.get(k + 1));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2, 5, 2, 3, 7};
        System.out.println(findLHS(nums));
    }
}