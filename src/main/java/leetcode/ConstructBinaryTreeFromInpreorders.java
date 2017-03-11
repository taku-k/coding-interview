package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInpreorders {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> nodeToInorderIdx = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i) {
            nodeToInorderIdx.put(inorder[i], i);
        }
        return rec(nodeToInorderIdx, preorder, 0, preorder.length, 0, inorder.length);
    }

    private TreeNode rec(Map<Integer, Integer> nodeToInorderIdx, int[] preorder,
                         int preorderStart, int preorderEnd, int inorderStart, int inorderEnd) {
        if (preorderEnd <= preorderStart || inorderEnd <= inorderStart) {
            return null;
        }
        int rootIdx = nodeToInorderIdx.get(preorder[preorderStart]);
        int leftTreeSize = rootIdx - inorderStart;
        TreeNode node = new TreeNode(preorder[preorderStart]);
        node.left = rec(nodeToInorderIdx, preorder, preorderStart + 1,
                preorderStart + 1 + leftTreeSize, inorderStart, rootIdx);
        node.right = rec(nodeToInorderIdx, preorder, preorderStart + 1 + leftTreeSize,
                preorderEnd, rootIdx + 1, inorderEnd);
        return node;
    }
}
