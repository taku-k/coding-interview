package leetcode;

public class PopulatingNextRightPointerEachNode2 {
    public void connect(TreeLinkNode root) {
        TreeLinkNode mostLeft = root;
        while (mostLeft != null) {
            TreeLinkNode iter = mostLeft;
            TreeLinkNode prev = new TreeLinkNode(0);
            while (iter != null) {
                if (iter.left != null) {
                    prev.next = iter.left;
                    prev = iter.left;
                }
                if (iter.right != null) {
                    prev.next = iter.right;
                    prev = iter.right;
                }
                iter = iter.next;
            }

            TreeLinkNode nextMostLeft = mostLeft;
            do {
                if (nextMostLeft.left != null) {
                    nextMostLeft = nextMostLeft.left;
                    break;
                } else if (nextMostLeft.right != null) {
                    nextMostLeft = nextMostLeft.right;
                    break;
                } else {
                    nextMostLeft = nextMostLeft.next;
                }
            } while (nextMostLeft != null);
            mostLeft = nextMostLeft;
        }
    }
}
