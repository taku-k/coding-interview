package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> result = new ArrayList<>();
    helper(root, sum, 0, new ArrayList<>(), result);
    return result;
  }

  private void helper(
      TreeNode node, int sum, int partialSum, List<Integer> path, List<List<Integer>> result) {
    if (node == null) return;
    partialSum += node.val;
    path.add(node.val);
    if (node.left == null && node.right == null) {
      if (partialSum == sum) {
        result.add(new ArrayList<>(path));
      }
    }
    helper(node.left, sum, partialSum, path, result);
    helper(node.right, sum, partialSum, path, result);
    path.remove(path.size() - 1);
  }
}
