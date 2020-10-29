/*

Leetcode Problem 226: Invert Binary Tree (Easy)

Invert a binary tree.

Complexity for this solution:
...

*/

public class InvertTree {

    public static TreeNode invert(TreeNode root) {
        if (root == null) return root;

        TreeNode left = invert(root.left);
        TreeNode right = invert(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        TreeNode rootInv = invert(root);
        System.out.println("rootInv value: " + rootInv.val);
        System.out.println("rootInv left: " + rootInv.left.val);
        System.out.println("rootInv right: " + rootInv.right.val);
    }
}
