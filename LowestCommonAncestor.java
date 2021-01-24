/*

Leetcode Problem 236: Lowest Common Ancestor of a Binary Tree (Medium)

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia:
“The lowest common ancestor is defined between two nodes p and q as the lowest node in T
that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Complexity for the solutions:
Solution 1 (recursion): O(n) time and space (space complexity because of recursion --> call stack)
Solution 2 (iterative): O(n) time and space (worst case)

*/

import java.util.*;

public class LowestCommonAncestor {

    /* Solution 1: Recursion
    https://www.youtube.com/watch?v=13m9ZCB8gjw&ab_channel=TusharRoy-CodingMadeSimple
    */
    public static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor1(root.left, p, q);
        TreeNode right = lowestCommonAncestor1(root.right, p, q);

        if (left != null && right != null) { // p and q on same side of the root --> root is LCA
            return root;
        } else if (left == null && right == null) { // p and q not found (in current subtree)
            return null;
        }

        // return side that was not null (i.e., that contained p and q)
        return left == null ? right : left;
    }

    /* Solution 2: iterative (using a stack)
    https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/discuss/65236/JavaPython-iterative-solution
    */
    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> stack = new ArrayDeque<>(); // stack to process tree nodes
        Map<TreeNode, TreeNode> parent = new HashMap<>(); // keep track of parents of every node processed in the stack
        parent.put(root, null);
        stack.push(root);

        // Process nodes in the tree until we have seen and processed both p and q.
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }

        // At this point, the map contains every node up to p and q with their respective parents.

        // Get all ancestors of p by moving upwards until we arrive at the root (parent of root is null).
        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }

        // If q is an ancestor of p, return q. Otherwise move upwards from q (getting the parents)
        // until we find a common ancestor, this is the LCA.
        while (!ancestors.contains(q)) {
            q = parent.get(q);
        }

        return q;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode p = root.left;
        TreeNode q = root.right;

        System.out.println(lowestCommonAncestor2(root, p, q).val);
    }
}
