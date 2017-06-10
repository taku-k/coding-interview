package epi.ch14;

import static org.junit.Assert.*;

import epi.util.BSTNode;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class ReconstructBinaryTreePreInordersTest {
  @Test
  public void test() {
    List<Integer> preorder = Arrays.asList(3, 2, 1, 5, 4, 6);
    BSTNode<Integer> tree = ReconstructBinaryTreePreInorders.rebuildBSTFromPreorder(preorder);
    checkAns(tree, Integer.MIN_VALUE);
    assertTrue(3 == tree.data);
    assertTrue(2 == tree.left.data);
    assertTrue(1 == tree.left.left.data);
    assertTrue(5 == tree.right.data);
    assertTrue(4 == tree.right.left.data);
    assertTrue(6 == tree.right.right.data);
  }

  private static void checkAns(BSTNode<Integer> n, Integer pre) {
    if (n != null) {
      checkAns(n.left, pre);
      assert(Integer.compare(pre, n.data) <= 0);
      checkAns(n.right, n.data);
    }
  }
}