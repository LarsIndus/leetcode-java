/*

Leetcode Problem 26: Remove Duplicates from Sorted Array (Easy)

Given a sorted array nums, remove the duplicates in-place
such that each element appears only once and returns the new length.

Do not allocate extra space for another array,
you must do this by modifying the input array in-place with O(1) extra memory.

Complexity for this solution:
O(n) time and O(1) space

*/

public class RemoveDuplicatesFromSortedArray {
    
    // Solution 1:
    // Place unique elements at the start of the array.
    public static int removeDuplicates1(int[] nums) {
        // Set up the index where we are going to replace elements.
        // We don't want to replace the first element (there cannot be any duplicate at index 0).
        int index = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            // If we see two elements that are not equal,
            // place the second one at the current index.
            // Then, increment index.
            if (nums[i] != nums[i + 1]) {
                nums[index++] = nums[i + 1];
            }
        }

        // Print the modified array to better understand the solution:
        System.out.println("Modified array:");
        System.out.print("[");
        for (int k = 0; k < nums.length; k++) {
            String toPrint = (k == nums.length - 1) ? nums[k] + "" : nums[k] + ", ";
            System.out.print(toPrint);
        }
        System.out.println("]");

        // The length of the modified array is the current index.
        return index;
    }

    // Solution 2 (my initial solution):
    // Place unique elements at the start of the array.
    public static int removeDuplicates2(int[] nums) {
        // first pointer starts at the array's head
        int i = 0;
        while (i < nums.length) {
            // Second pointer starts at i and is moved forward as long as we do not see a strictly larger element.
            int j = i;
            while (j < nums.length && nums[i] >= nums[j]) {
                j++;
            }
            // if j is still inside the bounds, place the element from position j one after i and increment i
            if (j < nums.length) {
                nums[i + 1] = nums[j];
                i++;
            // If we alredy reached the end of the array, break out of the loop.
            } else {
                break;
            }
        }

        // Print the modified array to better understand the solution:
        System.out.println("Modified array:");
        System.out.print("[");
        for (int k = 0; k < nums.length; k++) {
            String toPrint = (k == nums.length - 1) ? nums[k] + "" : nums[k] + ", ";
            System.out.print(toPrint);
        }
        System.out.println("]");
        
        // After breaking out of the loop, the length of the new array is the current index + 1.
        return i + 1;


    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 3, 3, 4};
        System.out.println(removeDuplicates1(nums));
    }
}
