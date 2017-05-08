package leetcode;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePaths {
  public List<String> binaryTreePaths(TreeNode root) {
    List<String> paths = new LinkedList<>();
    if (root != null) helper(root, "", paths);
    return paths;
  }

  private void helper(TreeNode root, String path, List<String> paths) {
    if (root == null) return;
    String nextPath = path + String.valueOf(root.val);
    if (root.left == null && root.right == null) paths.add(nextPath);
    helper(root.left, nextPath + "->", paths);
    helper(root.right, nextPath + "->", paths);
  }
}
