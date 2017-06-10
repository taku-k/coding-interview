package leetcode;

public class ConstructStrFromBT {
  public String tree2str(TreeNode t) {
    StringBuilder sb = new StringBuilder();
    if (t == null) return "";
    preOrder(t, sb);
    return sb.toString();
  }

  private void preOrder(TreeNode t, StringBuilder sb) {
    sb.append(t.val);
    if (t.left != null) {
      sb.append('(');
      preOrder(t.left, sb);
      sb.append(')');
    }
    if (t.right != null) {
      if (t.left == null) sb.append("()");
      sb.append('(');
      preOrder(t.right, sb);
      sb.append(')');
    }
  }
}
