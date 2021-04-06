/*

Leetcode Problem 103: Binary Tree Zigzag Level Order Traversal (Medium)

Given the root of a binary tree, return the zigzag level order traversal of its nodes' values
(i.e., from left to right, then right to left for the next level and alternate between).

Complexity for this solution:
O(n) time and space

*/

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class BinaryTreeZigzagLevelOrderTraversal {

    /*
    Solution 1:
    BFS traversal with a direction flag that is flipped after each level.
    In this solution, the nodes are not actually traversed in the zigzag pattern,
    but rather in the normal fashion (left to right).
    Each level's nodes are temporarily stored in an array, which is then traversed
    either from left to right or right to left depending on boolean flag.
    See solution 2 for a way to traverse the nodes in zigzag order.
    */
    public static List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        // Set up the queue and add root, start from left to right on the first level.
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            // Save values of the current level in normal order (left to right) in this array.
            int[] temp = new int[size];
            // Process all nodes on current level (add to array; add children to queue).
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                temp[i] = node.val;
                // Add children in normal order (left to right) to the queue.
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            // Build the current level for the result:
            // Depending on our boolean, add values from the array from left to right or vice versa.
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (leftToRight) {
                    currentLevel.add(temp[i]);
                } else {
                    currentLevel.add(temp[size - 1 - i]);
                }
            }

            // Add current level to result and flip the direction.
            result.add(currentLevel);
            leftToRight = !leftToRight;
        }

        return result;
    }

    /*
    Solution 1: Using two stacks
    The first stack holds the nodes on the current level (all odd levels),
    the second stack the nodes on the next level (all even levels).
    */
    public static List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);

        // Process all nodes (note that when s1 is empty, s2 must be empty, too).
        while (!s1.isEmpty()) {

            List<Integer> temp = new ArrayList<>();
            while (!s1.isEmpty()) {
                TreeNode node = s1.pop();
                temp.add(node.val);
                // Add children from left to right on odd levels.
                // Grabbing them from the stack later will result in the reverse order
                // (FILO property of stacks), which is exactly what we want.
                if (node.left != null) s2.push(node.left);
                if (node.right != null) s2.push(node.right);
            }
            result.add(temp);

            temp = new ArrayList<>();
            while (!s2.isEmpty()) {
                TreeNode node = s2.pop();
                temp.add(node.val);
                // Add children from right to left on even levels.
                // Grabbing them from the stack later will result in the reverse order
                // (FILO property of stacks), which is exactly what we want.
                if (node.right != null) s1.push(node.right);
                if (node.left != null) s1.push(node.left);
            }

            if (!temp.isEmpty()) result.add(temp);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(zigzagLevelOrder2(root));
    }
}