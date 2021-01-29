/*

Leetcode Problem 47: Permutations II (Medium)

Given a collection of numbers, nums, that might contain duplicates,
return all possible unique permutations in any order.

Complexity for this solution:
O(n * n!) time and space (n! = max possible number of permutations, n = traverse the input array).
If we don't consider the space for the final result, space complexity becomes O(n)
(e.g., when just asked to print the permutations instead of saving them).

*/

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class PermutationsII {
    
    // backtracking approach; most logic is inside the helper function
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, permutations, new ArrayList<>(), new boolean[nums.length]);
        return permutations;
    }

    // helper function to generate permutations
    // use a boolean array to keep track of already used elements
    public static void helper(int[] nums, List<List<Integer>> permutations, List<Integer> current, boolean[] used) {
        // If we have as many elements as in the array, we found a permutation.
        if (current.size() == nums.length) {
            // Be careful to pass a copy of current to our permutations list, not the original!
            permutations.add(new ArrayList<>(current));
            return;
        }

        // If we haven't added all elements yet, continue building the permutation.
        for (int i = 0; i < nums.length; i++) {
            // Add first element that is not present in the current permutation yet
            // and call the helper recursively;
            // after that delete last element (backtracking).

            // Check for unique permutations:
            // If the number has already been used, or it is the same as its predecessor
            // which hasn't been used in that permutation (due to backtracking), continue
            if(used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            used[i] = true; 
            current.add(nums[i]);
            helper(nums, permutations, current, used);
            // backtracking:
            used[i] = false; 
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(permuteUnique(nums));
    }
}