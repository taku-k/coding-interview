package leetcode;

public class BinaryTreeTilt {
  private class Tilt {
    int sum;
    int tilt;

    Tilt(int sum, int tilt) {
      this.sum = sum;
      this.tilt = tilt;
    }
  }

  public int findTilt(TreeNode root) {
    if (root == null) return 0;
    Tilt left = helper(root.left);
    Tilt right = helper(root.right);
    return Math.abs(left.sum - right.sum) + left.tilt + right.tilt;
  }

  private Tilt helper(TreeNode root) {
    if (root == null) return new Tilt(0, 0);
    Tilt left = helper(root.left);
    Tilt right = helper(root.right);
    int sum = left.sum + right.sum + root.val;
    int tilt = Math.abs(left.sum - right.sum) + left.tilt + right.tilt;
    Tilt cur = new Tilt(sum, tilt);
    return cur;
  }
}
