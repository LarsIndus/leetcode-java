/*

Leetcode Problem 257: Binary Tree Paths (Easy)

Given a binary tree, return all root-to-leaf paths.

Complexity for the solutions:
O(n) time and space with n being the number of nodes in the tree (?)

*/

import java.util.List;
import java.util.ArrayList;

public class BinaryTreePaths {

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) return paths;
        StringBuilder currentPath = new StringBuilder();
        // do a dfs starting from root to find all the paths
        dfs(root, currentPath, paths);
        return paths;
    }

    public static void dfs(TreeNode node, StringBuilder currentPath, List<String> paths) {
        if (node == null) return;

        // save current path length so that we can reset later
        int currentLength = currentPath.length();

        // append node's value
        currentPath.append(node.val);

        // if at a leaf, add the path to the list
        if (node.left == null && node.right == null) {
            paths.add(currentPath.toString());
        } else { // if not at a leaf, append an arrow and continue the dfs
            currentPath.append("->");
            dfs(node.left, currentPath, paths);
            dfs(node.right, currentPath, paths);
        }

        // delete the part of the path that has been added in this recursion
        currentPath.setLength(currentLength);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(binaryTreePaths(root));
    }
}
