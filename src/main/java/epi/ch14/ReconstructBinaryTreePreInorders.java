package epi.ch14;

import epi.util.BSTNode;
import java.util.List;

public class ReconstructBinaryTreePreInorders {
  public static BSTNode<Integer> rebuildBSTFromPreorder(List<Integer> preorder) {
    return rebuildRec(preorder, 0, preorder.size() - 1);
  }

  private static BSTNode<Integer> rebuildRec(List<Integer> pre, int l, int r) {
    if (l > r) {
      return null;
    }
    int trans = l + 1;
    while (trans <= r && pre.get(trans) < pre.get(l)) {
      ++trans;
    }
    return new BSTNode<>(pre.get(l), rebuildRec(pre, l + 1, trans - 1), rebuildRec(pre, trans, r));
  }
}
