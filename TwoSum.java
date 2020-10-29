/*

Leetcode Problem 1: Two Sum (Easy)

Given an array of integers nums and an integer target,
return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution,
and you may not use the same element twice.
You can return the answer in any order.

Complexity for this solution:
...

*/

import java.util.HashMap;

public class TwoSum {
    public static int[] getIndices(int[] arr, int target) {
        HashMap<Integer, Integer> complements = new HashMap<Integer, Integer>();
        int[] result = new int[2];

        for (int index = 0; index < arr.length; index++) {
            int num = arr[index];
            if (complements.containsKey(num)) {
                result[0] = complements.get(num);
                result[1] = index;
            } else {
                complements.put(target - num, index);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 6, 11};
        int target = 16;
        int[] result = TwoSum.getIndices(arr, target);
        for (int index : result) {
            System.out.println(index);
        }
    }
}
