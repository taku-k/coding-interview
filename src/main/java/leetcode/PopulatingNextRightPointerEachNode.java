package leetcode;

public class PopulatingNextRightPointerEachNode {
    public void connect(TreeLinkNode root) {
        TreeLinkNode leftStart = root;
        while (leftStart != null && leftStart.left != null) {
            TreeLinkNode iter = leftStart;
            while (iter != null) {
                iter.left.next = iter.right;
                if (iter.next != null) {
                    iter.right.next = iter.next.left;
                }
                iter = iter.next;
            }
            leftStart = leftStart.left;
        }
    }
}

