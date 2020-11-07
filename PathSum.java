/*

Leetcode Problem 112: Path Sum (Easy)

Given a binary tree and a sum, determine if the tree has a root-to-leaf path
such that adding up all the values along the path equals the given sum.

Complexity for this solution:
O(n) time and O(1) space

*/

public class PathSum {
    
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        sum -= root.val;
        
        // If we are at a leaf, check if all values summed up to the target
        if (root.left == null && root.right == null) {
            return sum == 0;
        }

        // If not at a leaf, try going left and right
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
        
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
        root.right.right.right = new TreeNode(1);

        int sum = 22;

        System.out.println(hasPathSum(root, sum));
    }

}
