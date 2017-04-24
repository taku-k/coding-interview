package leetcode;

public class DiameterBinaryTree {
    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return ans;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        ans = Math.max(ans, left + right);
        return Math.max(right, left) + 1;
    }
}
