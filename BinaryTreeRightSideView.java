/*

Leetcode Problem 199: Binary Tree Right Side View (Medium)

Given a binary tree, imagine yourself standing on the right side of it,
return the values of the nodes you can see ordered from top to bottom.

Complexity for this solution:
O(n) time and space
(Worst case: Queue has to hold an entire level of the tree,
which in a balanced tree is n/2 + 1 nodes on the last level.)

*/

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class BinaryTreeRightSideView {
    
    /* Using a queue to process the tree nodes (BFS approach):
    Process the tree nodes level by level. On each level, there is exactly one visible node,
    namely the one furthest to the right.
    If we add nodes to the queue from left to right, the visible node will always be the last
    node processed on each level.
    */
    public static List<Integer> rightSideView(TreeNode root) {
        // setting up the result list and doing an initial check
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        // set up the queue and add the root
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            // process all nodes on current level
            for (int i = queue.size(); i > 0; i--) {
                TreeNode current = queue.poll();
                // in the last iteration, we get the right-most node --> this is the only visible node
                if (i == 1) {
                    result.add(current.val);
                }

                // add children to the queue (from left to right)
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(6);
        root.right.right.left.left = new TreeNode(8);

        // expected output: [3, 20, 7, 6, 8]
        System.out.println(rightSideView(root));
    }
}