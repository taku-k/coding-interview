package leetcode;

import java.util.Stack;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean dfs(TreeNode root, Long lower, Long upper) {
        if (root == null) {
            return true;
        }
        if (root.val <= lower || root.val >= upper) {
            return false;
        }
        return dfs(root.left, lower, (long)root.val) && dfs(root.right, (long)root.val, upper);
    }

    private boolean stackInorder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode prev = null;
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode p = stack.pop();
                if (prev != null && p.val <= prev.val) {
                    return false;
                }
                prev = p;
                curr = p.right;
            }
        }
        return true;
    }
}
