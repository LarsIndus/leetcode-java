/*

Leetcode Problem 102: Binary Tree Level Order Traversal (Medium)

Given a binary tree, return the level order traversal of its nodes' values.
(i.e., from left to right, level by level).

Complexity for this solution:
O(n) time and space

*/

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class BinaryTreeLevelOrderTraversal {
    
    // solution using a queue (like a BFS)
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        // process tree nodes in a queue
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> currentLevel = new ArrayList<>();
            // Start with i = queue.size() and then decrement,
            // so that the size is only evaluated at the start of the loop
            // (this way, only the current level is processed).
            for (int i = queue.size(); i > 0; i--) {
                // add values of the current level's nodes
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);
                // add children if not null
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            // add the current level to our result list
            result.add(currentLevel);

        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(levelOrder(root));
    }
}