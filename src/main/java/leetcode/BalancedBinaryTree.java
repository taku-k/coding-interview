package leetcode;

public class BalancedBinaryTree {
    private class BalancedAndHeight {
        public boolean isBalanced;
        public int height;
        BalancedAndHeight(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return rec(root).isBalanced;
    }

    private BalancedAndHeight rec(TreeNode root) {
        if (root == null) {
            return new BalancedAndHeight(true, -1);
        }
        BalancedAndHeight left = rec(root.left);
        BalancedAndHeight right = rec(root.right);
        int height = Math.max(left.height, right.height) + 1;
        boolean isBalanced = Math.abs(left.height - right.height) < 2;
        return new BalancedAndHeight(isBalanced && left.isBalanced && right.isBalanced, height);
    }
}
