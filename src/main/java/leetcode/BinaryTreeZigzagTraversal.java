package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> traversal = new LinkedList<>();
        Deque<TreeNode> currLevel = new LinkedList<>();
        if (root == null) return traversal;
        currLevel.addLast(root);
        boolean leftToRight = false;
        while (!currLevel.isEmpty()) {
            Deque<TreeNode> nextLevel = new LinkedList<>();
            List<Integer> subList = new LinkedList<>();
            while (!currLevel.isEmpty()) {
                TreeNode curr = currLevel.removeFirst();
                subList.add(curr.val);
                if (leftToRight) {
                    if (curr.right != null) nextLevel.addFirst(curr.right);
                    if (curr.left != null) nextLevel.addFirst(curr.left);
                } else {
                    if (curr.left != null) nextLevel.addFirst(curr.left);
                    if (curr.right != null) nextLevel.addFirst(curr.right);
                }
            }
            leftToRight = !leftToRight;
            currLevel = nextLevel;
            traversal.add(subList);
        }
        return traversal;
    }
}
