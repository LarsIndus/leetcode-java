/*

Leetcode Problem 39: Combination Sum (Medium)

Given an array of distinct integers candidates and a target integer target,
return a list of all unique combinations of candidates where the chosen numbers sum to target.
You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times.
Two combinations are unique if the frequency of at least one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to target
is less than 150 combinations for the given input.

Complexity for this solution:
O(2^n) time, O(n) space (not considering the space for the result but just recursion)
(Time complexity might be O(n * 2^n) ...?)

*/

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class CombinationSum {

    // backtracking approach; most logic is inside the helper function
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            current.add(candidates[i]);
            // not i + 1 because we can reuse same elements:
            findCombinations(candidates, i, target - candidates[i], current, result);
            current.remove(current.size() - 1);
        }

    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 5};
        int target = 8;
        System.out.println(combinationSum(candidates, target));
    }
}