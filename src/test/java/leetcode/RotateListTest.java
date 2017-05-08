package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class RotateListTest {
  @Test
  public void rotateRight() throws Exception {
    ListNode head = Utils.lns("1,2,3,4,5");
    ListNode actual = RotateList.rotateRight(head, 2);
    assertEquals("4,5,1,2,3", Utils.lnd(actual));

    head = Utils.lns("1,2");
    actual = RotateList.rotateRight(head, 1);
    assertEquals("2,1", Utils.lnd(actual));
  }
}
