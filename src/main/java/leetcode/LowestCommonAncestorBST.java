package leetcode;

public class LowestCommonAncestorBST {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    TreeNode res = root;
    while (!(res.val >= p.val && res.val <= q.val)) {
      if (res.val < p.val) {
        res = res.right;
      }
      if (res.val > q.val) {
        res = res.left;
      }
    }
    return res;
  }
}
