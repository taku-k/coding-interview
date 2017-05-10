package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraversal {
  public List<Integer> inorderTraversal(TreeNode root) {
    TreeNode iter = root;
    Deque<TreeNode> stack = new LinkedList<>();
    List<Integer> result = new ArrayList<>();
    while (!stack.isEmpty() || iter != null) {
      if (iter != null) {
        stack.addFirst(iter);
        iter = iter.left;
      } else {
        iter = stack.pollFirst();
        result.add(iter.val);
        iter = iter.right;
      }
    }
    return result;
  }
}
