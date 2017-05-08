package leetcode;

public class SubtreeOfAnotherTree {
  public boolean isSubtree(TreeNode s, TreeNode t) {
    if (s == null) return false;
    if (s.val == t.val) {
      return check(s, t) || isSubtree(s.right, t) || isSubtree(s.left, t);
    } else {
      return isSubtree(s.right, t) || isSubtree(s.left, t);
    }
  }

  private boolean check(TreeNode s, TreeNode cur) {
    if ((s == null && cur != null) || (s != null && cur == null)) return false;
    if (s == null && cur == null) return true;
    if (s.val != cur.val) return false;
    return check(s.left, cur.left) && check(s.right, cur.right);
  }
}
