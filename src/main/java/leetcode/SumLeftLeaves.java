package leetcode;

public class SumLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        return rec(root, root);
    }

    private int rec(TreeNode curr, TreeNode parent) {
        if (curr == null) return 0;
        if (curr.left == null && curr.right == null && parent.left == curr) {
            return curr.val;
        }
        return rec(curr.left, curr) + rec(curr.right, curr);
    }
}
