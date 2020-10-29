/*

Leetcode Problem 40: Combination Sum II (Medium)

Given a collection of candidate numbers (candidates) and a target number (target),
find all unique combinations in candidates where the candidate numbers sums to target.
Each number in candidates may only be used once in the combination.

Note:

    - All numbers (including target) will be positive integers.
    - The solution set must not contain duplicate combinations.

Complexity for this solution:
O(2^n) time, O(n) space

*/

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class CombinationSumII {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(candidates, 0, target, new ArrayList<Integer>(), result);
        return result;
    }

    public static void findCombinations(int[] candidates, int index, int target,
                                        List<Integer> current, List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i == index || candidates[i] != candidates[i - 1]) {
                current.add(candidates[i]);
                findCombinations(candidates, i + 1, target - candidates[i], current, result);
                current.remove(current.size() - 1);
            }
        }

    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> result = combinationSum2(candidates, target);
        
        for (List<Integer> l1 : result) {
            for (int n : l1) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}
