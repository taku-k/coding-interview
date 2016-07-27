package leetcode;

import java.util.LinkedList;

/**
 * Created by taku on 7/19/16.
 */
public class BSTIterator {
    private LinkedList<Integer> list = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        list = new LinkedList<>();
        iter(root);
    }

    private void iter(TreeNode node) {
        if (node == null) {
            return;
        }
        iter(node.left);
        list.addLast(node.val);
        iter(node.right);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !list.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        return list.poll();
    }
}
