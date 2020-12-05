/*

Leetcode Problem 113: Path Sum II (Medium)

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Complexity for this solution:
...

*/

import java.util.List;
import java.util.ArrayList;

public class PathSumII {

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> paths = new ArrayList<>();
        findPaths(root, sum, new ArrayList<Integer>(), paths);
        return paths;
    }

    public static void findPaths(TreeNode root, int sum, List<Integer> current, List<List<Integer>> paths) {
        if (root == null) return;

        current.add(root.val);
        if (root.val == sum && root.left == null && root.right == null) {
            paths.add(new ArrayList<>(current));
            return;
        }

        findPaths(root.left, sum - root.val, current, paths);
        findPaths(root.right, sum - root.val, current, paths);

        // backtracking
        current.remove(current.size() - 1);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        int sum = 22;

        List<List<Integer>> paths = pathSum(root, sum);
        for (List<Integer> path : paths) {
            for (int n : path) {
                System.out.print(n + " ");
            }
            System.out.println();
        }

    }
}
