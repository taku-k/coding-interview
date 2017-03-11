package leetcode;

import java.util.*;

public class BinaryTreeLevelOrderTraversalFromBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levelsList = new ArrayList<>();
        Queue<TreeNode> currLevel = new LinkedList<>();
        if (root == null) return levelsList;
        currLevel.offer(root);
        while (!currLevel.isEmpty()) {
            Queue<TreeNode> nextLevel = new LinkedList<>();
            List<Integer> subList = new ArrayList<>();
            while (!currLevel.isEmpty()) {
                TreeNode curr = currLevel.poll();
                if (curr.left != null) nextLevel.offer(curr.left);
                if (curr.right != null) nextLevel.offer(curr.right);
                subList.add(curr.val);
            }
            levelsList.add(0, subList);
            currLevel = nextLevel;
        }
        return levelsList;
    }
}
