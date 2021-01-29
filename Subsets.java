/*

Leetcode Problem 78: Subsets (Medium)

Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Complexity for this solution:
O(n * 2^n) time and space (2^n subsets and traverse at most n times to generate each subset).
If we don't consider the space for the final result, space complexity becomes O(n)
(e.g., when just asked to print the subsets instead of saving them).

*/

import java.util.List;
import java.util.ArrayList;

public class Subsets {

    // backtracking approach; most logic is inside the helper function
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        generateSubset(nums, subsets, new ArrayList<>(), 0);
        return subsets;
    }

    // helper function to generate subsets
    public static void generateSubset(int[] nums, List<List<Integer>> subsets, List<Integer> current, int index) {
        // Be careful to pass a copy of current to our subsets list, not the original!
        subsets.add(new ArrayList<>(current));

        // Go through the next elements and call the helper recursively;
        // after that delete last element (backtracking).
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            generateSubset(nums, subsets, current, i + 1);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }
}