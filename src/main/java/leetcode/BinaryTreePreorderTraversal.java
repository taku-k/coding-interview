package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversal {
  public List<Integer> preorderTraversal(TreeNode root) {
    TreeNode iter = root;
    Deque<TreeNode> stack = new LinkedList<>();
    List<Integer> result = new ArrayList<>();
    while (!stack.isEmpty() || iter != null) {
      if (iter != null) {
        result.add(iter.val);
        stack.addFirst(iter);
        iter = iter.left;
      } else {
        iter = stack.pollFirst();
        iter = iter.right;
      }
    }
    return result;
  }
}
