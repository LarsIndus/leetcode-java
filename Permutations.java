/*

Leetcode Problem 46: Permutations (Medium)

Given an array nums of distinct integers, return all the possible permutations.
You can return the answer in any order.

Complexity for this solution:
O(n * n!) time and space (n! = number of permutations, n = traverse the input array).
If we don't consider the space for the final result, space complexity becomes O(n)
(e.g., when just asked to print the permutations instead of saving them).

*/

import java.util.List;
import java.util.ArrayList;

public class Permutations {
    
    // backtracking approach; most logic is inside the helper function
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        helper(nums, permutations, new ArrayList<>());
        return permutations;
    }

    // helper function to generate permutations
    public static void helper(int[] nums, List<List<Integer>> permutations, List<Integer> current) {
        // If we have as many elements as in the array, we found a permutation.
        if (current.size() == nums.length) {
            // Be careful to pass a copy of current to our permutations list, not the original!
            permutations.add(new ArrayList<>(current));
            return;
        }

        // If we haven't added all elements yet, continue building the permutation.
        for (int k : nums) {
            // Add first element that is not present in the current permutation yet
            // and call the helper recursively;
            // after that delete last element (backtracking).
            if (!current.contains(k)) {
                current.add(k);
                helper(nums, permutations, current);
                current.remove(current.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }
}