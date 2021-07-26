/*

Leetcode Problem 101: Symmetric Tree (Easy)

Given the root of a binary tree, check whether it is a mirror of itself
(i.e., symmetric around its center).

Complexity for this solution:
O(n) time and space (space complexity in the first solution because of recursion)

*/

import java.util.Queue;
import java.util.LinkedList;

public class SymmetricTree {
    
    // Solution 1: recursive
    public static boolean isSymmetric1(TreeNode root) {
        return root == null || helper(root.left, root.right);
    }

    public static boolean helper(TreeNode left, TreeNode right) {
        if (left == null || right == null) return left == right;
        if (left.val != right.val) return false;
        return helper(left.left, right.right) && helper(left.right, right.left);
    }

    // Solution 2: iterative (using a stack and BFS)
    public static boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while(!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) continue;
            if (left == null || right == null || left.val != right.val) return false;

            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
            
        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(isSymmetric1(root));
    }
}