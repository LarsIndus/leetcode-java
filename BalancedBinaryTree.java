/*

Leetcode Problem 110: Balanced Binary Tree (Easy)

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as
a binary tree in which the left and right subtrees of every node differ in height by no more than 1.

Complexity for this solution:
Solution 1 (top-down approach): O(n^2) time and O(1) space
Solution 2 (bottom-up approach): O(n) time and O(1) space

*/

public class BalancedBinaryTree {
    
    /*
    Solution 1: Top-down approach
    Check by strictly using the definiton:
    For each node, calculate the depth of both subtrees (with a helper method)
    and check whether their difference is < 1.
    Then check the subtrees recursively.

    O(n^2) time complexity in the worst case, O(n log n) on average
    (calling the helper function has O(n) complexity, which happens for every node in the worst case)
    */
    public static boolean isBalanced1(TreeNode root) {
        if (root == null) return true;

        int depthLeft = getDepth(root.left);
        int depthRight = getDepth(root.right);

        return Math.abs(depthLeft - depthRight) < 2 && isBalanced1(root.left) && isBalanced1(root.right);

    }

    // Helper method to calculate the depth of a tree
    public static int getDepth(TreeNode node) {
        if (node == null) return 0;
        return Math.max(getDepth(node.left), getDepth(node.right)) + 1;
    }

    /*
    Solution 2: Bottom-up approach with DFS
    Instead of calculating the depth explicitly for each node, we return the height of the current node
    in the DFS recursion. When the subtree of the current node is balanced, the DFS returns
    a non-negative value, otherwise -1.

    O(n) time complexity
    */
    public static boolean isBalanced2(TreeNode root) {
        return dfsHeight(root) != - 1;
    }

    // Helper function to calculate the depth of a tree using a DFS
    public static int dfsHeight(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = dfsHeight(root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = dfsHeight(root.right);
        if (rightHeight == -1) return -1;

        // Check if subtrees of current node are balanced.
        // If not, -1 is returned and the 
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;


        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(isBalanced2(root));
    }
}