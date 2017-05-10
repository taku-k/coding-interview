package leetcode;

public class PathSum3 {

  public int pathSum(TreeNode root, int sum) {
    if (root == null) {
      return 0;
    }
    return helper(root, sum, 0) + pathSum(root.left, sum) + pathSum(root.right, sum);
  }

  private int helper(TreeNode node, int sum, int partialSum) {
    if (node == null) {
      return 0;
    }
    int result = 0;
    partialSum += node.val;
    if (partialSum == sum) {
      result += 1;
    }
    result += helper(node.left, sum, partialSum);
    result += helper(node.right, sum, partialSum);
    return result;
  }
}
