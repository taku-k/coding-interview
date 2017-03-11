package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightView = new ArrayList<>();
        if (root == null) return rightView;
        Deque<TreeNode> level = new LinkedList<>();
        level.addLast(root);
        while (!level.isEmpty()) {
            Deque<TreeNode> nextLevel = new LinkedList<>();
            TreeNode curr = null;
            while (!level.isEmpty()) {
                curr = level.removeFirst();
                if (curr.left != null) nextLevel.addLast(curr.left);
                if (curr.right != null) nextLevel.addLast(curr.right);
            }
            rightView.add(curr.val);
            level = nextLevel;
        }
        return rightView;
    }
}
