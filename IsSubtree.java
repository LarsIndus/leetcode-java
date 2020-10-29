/*

Leetcode Problem 572: Subtree of Another Tree (Easy)

Given two non-empty binary trees s and t,
check whether tree t has exactly the same structure and node values with a subtree of s.
A subtree of s is a tree consists of a node in s and all of this node's descendants.
The tree s could also be considered as a subtree of itself.

Complexity for this solution:
O(nm) time (n, m being sizes of the trees), O(min(n, m)) space (because of recursion!)

*/

public class IsSubtree {

    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (t == null) return true;
        if (s == null) return false;

        return SameTree.isSame(s, t) || isSubtree(s.left, t) || isSubtree(s.right,t );
    }

    public static void main(String[] args) {
        TreeNode s = new TreeNode(3);
        s.left = new TreeNode(4);
        s.right = new TreeNode(5);
        s.left.left = new TreeNode(1);
        s.left.right = new TreeNode(2);
        s.left.right.left = new TreeNode(0);

        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);

        System.out.println(isSubtree(s, t));
    }
}
