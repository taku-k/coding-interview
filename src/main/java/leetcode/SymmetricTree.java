package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class SymmetricTree {

  private static class ComparingTarget {

    public TreeNode left;
    public TreeNode right;

    ComparingTarget(TreeNode left, TreeNode right) {
      this.left = left;
      this.right = right;
    }
  }

  public boolean isSymmetric(TreeNode root) {
    if (root == null) return true;
    Deque<ComparingTarget> candidates = new LinkedList<>();
    candidates.addFirst(new ComparingTarget(root.left, root.right));
    while (!candidates.isEmpty()) {
      ComparingTarget target = candidates.pollFirst();
      TreeNode left = target.left;
      TreeNode right = target.right;
      if (left == null && right == null) continue;
      else if (left == null || right == null) return false;
      else if (left.val != right.val) return false;
      candidates.addFirst(new ComparingTarget(left.left, right.right));
      candidates.addFirst(new ComparingTarget(left.right, right.left));
    }
    return true;
  }
}
