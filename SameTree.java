/*

Leetcode Problem 100: Same Tree (Easy)

Given two binary trees, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical
and the nodes have the same value.

Complexity for this solution:
...

*/

public class SameTree {
    
    public static boolean isSame(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;

        return isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.right = new TreeNode(4);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        root2.right = new TreeNode(4);

        System.out.println(isSame(root1, root2));
    }

}
