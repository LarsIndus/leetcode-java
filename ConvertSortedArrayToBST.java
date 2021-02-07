/*

Leetcode Problem 108: Convert Sorted Array to Binary Search Tree (Easy)

Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree
in which the depth of the two subtrees of every node never differ by more than 1.

Complexity for this solution:
O(n) time and space

*/

public class ConvertSortedArrayToBST {
    
    /* 
    Construct tree recursively:
    The root should be the middle of the array.
    Then, construct the left subtree from the left subarray
    and the right subtree from the right subarray. 
    */
    public static TreeNode sortedArrayToBST(int[] nums) {
        // error checking
        if (nums == null || nums.length == 0) return null;
        // call helper on the full array (bounds 0 and nums.length - 1)
        return helper(nums, 0, nums.length - 1);
    }

    // Helper function:
    // constructs tree from a subarray (left, right being the bounds)
    private static TreeNode helper(int[] nums, int left, int right) {
        
        // If left > right, we are at a leaf, i.e., return null.
        if (left > right) return null;

        // Find the middle position of the current subarray,
        // and set its value as the current node (= root of current subtree).
        // Then construct left and right child by calling the helper recursively
        // on the left and right subarray.
        int mid = left + (right - left) / 2; // prevent overflow
        TreeNode current = new TreeNode(nums[mid]);
        current.left = helper(nums, left, mid - 1);
        current.right = helper(nums, mid + 1, right);

        return current;
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode root = sortedArrayToBST(nums);
        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.left.right.val);
        System.out.println(root.right.val);
        System.out.println(root.right.right.val);
    }
}