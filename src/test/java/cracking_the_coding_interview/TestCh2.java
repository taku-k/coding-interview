package cracking_the_coding_interview;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class TestCh2 {
  @Test
  public void testDropDuplicates() {
    Node n = Node.createNodes(new int[] {1, 3, 1, 2});

    Problem2_1.dropDuplicates(n);

    assertEquals(n.data, 1);
    assertEquals(n.next.data, 3);
    assertEquals(n.next.next.data, 2);
  }

  @Test
  public void testTakekNode() {
    Node n = Node.createNodes(new int[] {1, 2, 3, 4, 5, 6});

    int kNode = Problem2_2.takekNode(n, 3);

    assertEquals(kNode, 4);
  }

  @Test
  public void testAddLists() {
    Node n1 = Node.createNodes(new int[] {7, 1, 6});
    Node n2 = Node.createNodes(new int[] {5, 9, 2});

    Node ans = Problem2_5.addLists(n1, n2);
    assertEquals(Node.checkData(ans, new int[] {2, 1, 9}), true);
    assertEquals(
        Node.checkData(
            Problem2_5.addLists(
                Node.createNodes(new int[] {1, 1, 1}), Node.createNodes(new int[] {1, 1})),
            new int[] {2, 2, 1}),
        true);
  }

  @Test
  public void testDijkstra() {
    List<List<Integer>> g = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4));
  }
}
