package leetcode;

public class MergeTwoBinaryTrees {
  public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) {
      return null;
    } else if (t1 == null && t2 != null) {
      return t2;
    } else if (t1 != null && t2 == null) {
      return t1;
    } else {
      TreeNode n = new TreeNode(t1.val + t2.val);
      n.left = mergeTrees(t1.left, t2.left);
      n.right = mergeTrees(t1.right, t2.right);
      return n;
    }
  }
}
