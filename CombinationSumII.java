/*

Leetcode Problem 40: Combination Sum II (Medium)

Given a collection of candidate numbers (candidates) and a target number (target),
find all unique combinations in candidates where the candidate numbers sums to target.
Each number in candidates may only be used once in the combination.

Note:

    - All numbers (including target) will be positive integers.
    - The solution set must not contain duplicate combinations.

Complexity for this solution:
O(2^n) time, O(n) space (not considering the space for the result but just recursion)
(Time complexity might be O(n * 2^n) ...?)

*/

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class CombinationSumII {

    // backtracking approach; most logic is inside the helper function
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(candidates, 0, target, new ArrayList<Integer>(), result);
        return result;
    }

    // helper function to generate combinations
    public static void findCombinations(int[] candidates, int index, int target,
                                        List<Integer> current, List<List<Integer>> result) {

        // current combination sums up to target --> add to result and return                                            
        if (target == 0) {
            // Be careful to pass a copy of current to our result list, not the original!
            result.add(new ArrayList<>(current));
            return;
        }

        // Current combination sums to something larger than target;
        // --> return as we cannot find a valid combination from here (array is sorted!).
        if (target < 0) {
            return;
        }

        // Go through the next elements and call the helper recursively;
        // after that delete last element (backtracking).
        for (int i = index; i < candidates.length; i++) {
            // first check for duplicates
            if (i == index || candidates[i] != candidates[i - 1]) {
                current.add(candidates[i]);
                // i + 1 instead of i because we cannot reuse same elements:
                findCombinations(candidates, i + 1, target - candidates[i], current, result);
                current.remove(current.size() - 1);
            }
        }

    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(combinationSum2(candidates, target));
    }
}