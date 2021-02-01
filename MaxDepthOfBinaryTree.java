/*

Leetcode Problem 104: Maximum Depth of Binary Tree (Easy)

Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path
from the root node down to the farthest leaf node.

Complexity for this solution:
Time and space complexity is O(n) with n being the nuber of nodes in the tree.
Average space complexity is O(log n) for a balanced tree.

*/

public class MaxDepthOfBinaryTree {
    
    public static int getMaxDepth(TreeNode root) {
        if (root == null) return 0;
        
        int depthLeft = (root.left != null) ? getMaxDepth(root.left) : 0;
        int depthRight = (root.right != null) ? getMaxDepth(root.right) : 0;

        int depth = 1 + Math.max(depthLeft, depthRight);

        return depth;   
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(4);

        System.out.println(getMaxDepth(root));
    }

}
