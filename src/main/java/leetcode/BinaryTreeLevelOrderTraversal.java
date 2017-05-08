package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> levels = new LinkedList<>();
    Deque<TreeNode> level = new LinkedList<>();
    level.addLast(root);
    while (!level.isEmpty()) {
      List<Integer> levelList = new ArrayList<>();
      Deque<TreeNode> nextLevel = new LinkedList<>();
      while (!level.isEmpty()) {
        TreeNode curr = level.removeFirst();
        if (curr == null) continue;
        levelList.add(curr.val);
        nextLevel.addLast(curr.left);
        nextLevel.addLast(curr.right);
      }
      if (!levelList.isEmpty()) {
        levels.add(levelList);
      }
      level = nextLevel;
    }
    return levels;
  }
}
