/*

Leetcode Problem 235: Lowest Common Ancestor of a Binary Search Tree (Easy)

Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia:
“The lowest common ancestor is defined between two nodes p and q as the lowest node in T
that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Complexity for this solution:
O(log n) time and space with n being the number of nodes in the tree
(space complexity because of recursion --> call stack)

*/

public class LowestCommonAncestorBST {
    
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) { // p and q in the left subtree
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) { // p and q in the right subtree
            return lowestCommonAncestor(root.right, p, q);
        } else { // p and q are on different sides of root --> root is the solution
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        TreeNode p = root.left;
        TreeNode q = root.right;

        System.out.println(lowestCommonAncestor(root, p, q).val);
    }
}