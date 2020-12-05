/*

Leetcode Problem 1302: Deepest Leaves Sum (Medium)

Given a binary tree, return the sum of values of its deepest leaves.

Complexity for this solution:
O(N) time and space

*/

import java.util.Queue;
import java.util.LinkedList;

public class DeepestLeavesSum {
    
    // Solution 1: BFS
    public static int deepestLeavesSum1(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int sum = 0;

        while(!q.isEmpty()) {
            sum = 0;
            for (int size = q.size(); size > 0; size--) { // process all elements at the current level
                TreeNode curr = q.poll();
                sum += curr.val;
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
        }

        return sum;
    }

    // Solution 2: Recursion
    private static int sum = 0;
    private static int maxLevel = 0;
    public static int deepestLeavesSum2(TreeNode root) {
        if (root == null) return 0;
        calculateSumAtLevel(root, 0);
        return sum;
    }

    private static void calculateSumAtLevel(TreeNode root, int level){
       if (root == null) return;

        if (level > maxLevel){
            sum = 0;
            maxLevel = level;
        }
        if (level == maxLevel){
            sum = sum + root.val;
        }

        calculateSumAtLevel(root.left, level + 1);
        calculateSumAtLevel(root.right, level + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        System.out.println(deepestLeavesSum1(root));

    }
}
