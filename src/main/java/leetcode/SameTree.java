package leetcode;

/**
 * Created by taku on 8/1/16.
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p, q);
    }

    private boolean dfs(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }

        return dfs(p.left, q.left) && p.val == q.val && dfs(p.right, q.right);
    }
}
