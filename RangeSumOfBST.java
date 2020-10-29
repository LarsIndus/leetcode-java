/*

Leetcode Problem 938: Range Sum of BST (Easy)

Given the root node of a binary search tree,
return the sum of values of all nodes with value between L and R (inclusive).
The binary search tree is guaranteed to have unique values.

Complexity for this solution:
O(n log n) time, O(n) space

*/

import java.util.LinkedList;
import java.util.Queue;

public class RangeSumOfBST {

    // Solution 1: Breadth-First-Search
    public static int getRangeSumBFS(TreeNode root, int L, int R) {
        int result = 0;

        if (root == null) {
            return result;
        }

        // Set up a queue for nodes that we want to check
        // This implemented by a linked list in Java. (Queue is just an interface!)
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode current = queue.remove();
            System.out.println("Current ListNode: " + current.val);
            if (current.val >= L && current.val <= R) {
                System.out.println("Added " + current.val);
                result += current.val;
            } else {
                System.out.println("Don't add");
            }

            /* As this is a BST, we can check whether there are nodes
            that potentially need to be checked by checking whether the current value
            is between the bounds.
            Note that the tree has unique values so we can use strict inequalities. 
             */
            if (current.left != null && current.val > L) {
                queue.add(current.left);
            }
            if (current.right != null && current.val < R) {
                queue.add(current.right);
            }
        }

        return result;
        
    }

    // Solution 2: Depth-First-Search
    public static int getRangeSumDFS(TreeNode root, int L, int R) {
        int result = 0;

        if (root == null) {
            return result;
        }

        if (root.val >= L && root.val <= R) {
            System.out.println("Added " + root.val);
            result += root.val;
        }

        if (root.left != null && root.val > L) {
            result += getRangeSumDFS(root.left, L, R);
        }

        if (root.right != null && root.val < R) {
            result += getRangeSumDFS(root.right, L, R);
        }        

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(18);
        root.left.left.left = new TreeNode(1);
        root.left.right.left = new TreeNode(6);

        int L = 6;
        int R = 10;

        System.out.println("---------- SOLUTION USING BFS: ----------");
        System.out.println("Result: " + getRangeSumBFS(root, L, R));
        System.out.println("");
        System.out.println("---------- SOLUTION USING DFS: ----------");
        System.out.println("Result: " + getRangeSumDFS(root, L, R));
    }
}
