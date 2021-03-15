/*

Leetcode Problem 448: Find All Numbers Disappeared in an Array (Easy)

Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array),
some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime?
You may assume the returned list does not count as extra space.

Complexity for this solution:
O(n) time and O(1) space (disregarding the space for the output)

*/

import java.util.List;
import java.util.ArrayList;

public class FindAllNumbersDisappeared {
    
    /* 
    Idea:
    If the array was complete ([1, ..., n]) and sorted, we would have nums[i] = i + 1.
    Try to "sort" the array in linear time, such that the unique numbers are at the right index.
    Then loop through the array and check if nums[i] != i + 1.
    In this case, i + 1 is missing.

    The sorting is done as follows:
    For each index i, check whether the array holds the correct value i + 1.
    If not, check whether the correct position for that number (nums[nums[i] - 1])
    is already occupied by an incorrect value.
    If so, swap these two. After that, the array is sorted in the sense that each
    unique value is at the correct position.

    Example run:

    [4, 3, 2, 7, 8, 2, 3, 1]
    [7, 3, 2, 4, 8, 2, 3, 1]
    [3, 3, 2, 4, 8, 2, 7, 1]
    [2, 3, 3, 4, 8, 2, 7, 1]
    [3, 2, 3, 4, 8, 2, 7, 1]
    [3, 2, 3, 4, 1, 2, 7, 8]
    [1, 2, 3, 4, 3, 2, 7, 8]

    -> [5, 6] are missing
    */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                int tmp = nums[i];
                nums[i] = nums[tmp - 1];
                nums[tmp - 1] = tmp;
            }
        }

        // If nums[i] != i + 1, then i + 1 is missing.
        List<Integer> missing = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                missing.add(i + 1);
            }
        }

        return missing;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDisappearedNumbers(nums));
    }
}