package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePostorderTraversal {

  public List<Integer> postorderTraversal(TreeNode root) {
    TreeNode iter = root;
    Deque<TreeNode> stack = new LinkedList<>();
    List<Integer> result = new ArrayList<>();
    while (!stack.isEmpty() || iter != null) {
      if (iter != null) {
        stack.addFirst(iter);
        result.add(iter.val);
        iter = iter.right;
      } else {
        iter = stack.pollFirst();
        iter = iter.left;
      }
    }
    Collections.reverse(result);
    return result;
  }
}
