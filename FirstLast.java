/*

Leetcode Problem 34: Find First and Last Position of Element in Sorted Array (Medium)

Given an array of integers nums sorted in ascending order,
find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].

Follow up: Could you write an algorithm with O(log n) runtime complexity?

Complexity for this solution:
...

*/

public class FirstLast {
    
    // binary search that finds first occurrence of value >= target
    public static int firstPos(int[] nums, int target) {
        int n = nums.length;
        int firstPos = n;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] >= target) {
                firstPos = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return firstPos;
    }

    public static int[] searchRange(int[] nums, int target) {
        int first = firstPos(nums, target);
        int last = firstPos(nums, target + 1) - 1;
        if (first <= last) {
            return new int[] {first, last};
        } else {
            return new int[] {-1, -1};
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 7, 8, 8, 8, 9, 12};
        int target = 12;
        for (int i = 0; i <=1; i++) {
            System.out.println(searchRange(nums, target)[i]);
        }
    }

}
