/*

Leetcode Problem 217: Contains Duplicate (Easy)

Given an array of integers, find if the array contains any duplicates.
Your function should return true if any value appears at least twice in the array,
and it should return false if every element is distinct.

Complexity for this solution:
O(n) time and space complexity (first solution)
O(n log n) time and O(1) space (second solution)

*/

import java.util.*;

public class ContainsDuplicate {

    // Solution 1: Using a hash set
    public static boolean solution1(int[] nums) {
        HashSet<Integer> uniqueNumbers = new HashSet<>();
        for (int i : nums) {
            if (uniqueNumbers.contains(i)) return true;
            uniqueNumbers.add(i);
        }

        return false;
    }

    // Solution 2: Sorting the array
    public static boolean solution2(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) return true;
        }

        return false;

    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 3};
        int[] nums2 = {1, 2, 3, 4};
        int[] nums3 = {};
        System.out.println("nums1 with solution 1:" + solution1(nums1));
        System.out.println("nums2 with solution 1:" + solution1(nums2));
        System.out.println("nums3 with solution 1:" + solution1(nums3));
        System.out.println("nums1 with solution 2:" + solution2(nums1));
        System.out.println("nums2 with solution 2:" + solution2(nums2));
        System.out.println("nums3 with solution 2:" + solution2(nums3));
    }
}
