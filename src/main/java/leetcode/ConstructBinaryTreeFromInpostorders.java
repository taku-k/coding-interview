package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInpostorders {
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    Map<Integer, Integer> nodeToInorderIdx = new HashMap<>();
    for (int i = 0; i < inorder.length; ++i) {
      nodeToInorderIdx.put(inorder[i], i);
    }
    return rec(nodeToInorderIdx, postorder, 0, postorder.length, 0, inorder.length);
  }

  private TreeNode rec(
      Map<Integer, Integer> nodeToInorderIdx,
      int[] postorder,
      int postorderStart,
      int postorderEnd,
      int inorderStart,
      int inorderEnd) {
    if (postorderEnd <= postorderStart || inorderEnd <= inorderStart) {
      return null;
    }
    int rootIdx = nodeToInorderIdx.get(postorder[postorderEnd - 1]);
    int rightTreeSize = inorderEnd - rootIdx - 1;
    TreeNode node = new TreeNode(postorder[postorderEnd - 1]);
    node.left =
        rec(
            nodeToInorderIdx,
            postorder,
            postorderStart,
            postorderEnd - rightTreeSize - 1,
            inorderStart,
            rootIdx);
    node.right =
        rec(
            nodeToInorderIdx,
            postorder,
            postorderEnd - rightTreeSize - 1,
            postorderEnd - 1,
            rootIdx + 1,
            inorderEnd);
    return node;
  }
}
