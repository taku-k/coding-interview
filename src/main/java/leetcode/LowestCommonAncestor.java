package leetcode;

public class LowestCommonAncestor {
    private class Status {
        public int numTargets;
        public TreeNode ancestor;
        public Status(int numTargets, TreeNode ancestor) {
            this.numTargets = numTargets;
            this.ancestor = ancestor;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return rec(root, p, q).ancestor;
    }

    private Status rec(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return new Status(0, null);
        }
        Status left = rec(root.left, p, q);
        if (left.numTargets == 2) {
            return left;
        }
        Status right = rec(root.right, p, q);
        if (right.numTargets == 2) {
            return right;
        }
        int numTargets = left.numTargets + right.numTargets +
                (root == p ? 1 : 0) + (root == q ? 1 : 0);
        return new Status(numTargets, root);
    }
}
