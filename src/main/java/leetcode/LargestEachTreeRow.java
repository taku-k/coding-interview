package leetcode;

import java.util.*;

public class LargestEachTreeRow {
  public List<Integer> largestValues(TreeNode root) {
    if (root == null) return Collections.emptyList();
    Deque<TreeNode> que = new LinkedList<>();
    List<Integer> result = new ArrayList<>();
    que.addLast(root);
    while (!que.isEmpty()) {
      Deque<TreeNode> next = new LinkedList<>();
      int max = Integer.MIN_VALUE;
      while (!que.isEmpty()) {
        TreeNode cur = que.pollFirst();
        max = Math.max(max, cur.val);
        if (cur.left != null) next.addLast(cur.left);
        if (cur.right != null) next.addLast(cur.right);
      }
      result.add(max);
      que = next;
    }
    return result;
  }
}
