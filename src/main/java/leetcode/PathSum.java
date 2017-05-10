package leetcode;

public class PathSum {
  public boolean hasPathSum(TreeNode root, int sum) {
    return helper(root, sum, 0);
  }

  private boolean helper(TreeNode node, int sum, int partialSum) {
    if (node == null) return false;
    partialSum += node.val;
    if (node.left == null && node.right == null) {
      return partialSum == sum;
    }
    return helper(node.left, sum, partialSum) || helper(node.right, sum, partialSum);
  }
}
