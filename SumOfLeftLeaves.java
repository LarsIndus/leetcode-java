/*

Leetcode Problem 404: Sum of Left Leaves (Easy)

Find the sum of all left leaves in a given binary tree.

Complexity for this solution:
O(n) time and space (n being the number of nodes)
(Worst case: BFS queue has to hold an entire level of the tree,
which in a balanced tree is n/2 + 1 nodes on the last level.
For the recursive solution, the call stack will also have size n in the worst case.)

*/

import java.util.Queue;
import java.util.LinkedList;

public class SumOfLeftLeaves {
    
    // Solution 1: Using a queue to process the tree nodes (BFS approach)
    public static int sumOfLeftLeaves1(TreeNode root) {
        // initial check
        int result = 0;
        if (root == null) return result;

        // setting up the queue
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode current = queue.poll();
            // If there is a left child, check if it's a leaf.
            // If so, add its value to the result. Otherwise put it in the queue.
            if (current.left != null) {
                if (current.left.left == null && current.left.right == null) {
                    result += current.left.val;
                } else {
                    queue.offer(current.left);
                }
            }
            // If there is a right child, put it in the queue.
            if (current.right != null) {
                queue.offer(current.right);
            }
        }

        return result;
    }

    // Solution 2: recursive approach
    public static int sumOfLeftLeaves2(TreeNode root) {
        // initial check
        int result = 0;
        if (root == null) return result;

        // If there is a left child that is also a leaf, add its value to the result.
        // Otherwise call the function recursively on the left subtree.
        if (root.left != null && root.left.left == null && root.left.right == null) {
            result += root.left.val;
        } else {
            result += sumOfLeftLeaves2(root.left);
        }

        // Call the function recursively on the right subtree.
        result += sumOfLeftLeaves2(root.right);

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(sumOfLeftLeaves2(root));
    }
}