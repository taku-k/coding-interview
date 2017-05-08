package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

/** Created by taku on 2016/05/25. */
public class AddTwoNumbersTest {

  @Test
  public void addTwoNumbers() throws Exception {
    AddTwoNumbers atn = new AddTwoNumbers();
    ListNode l1 = Utils.lns("2,4,3");
    ListNode l2 = Utils.lns("5,6,4");
    assertEquals("7,0,8", Utils.lnd(atn.addTwoNumbers(l1, l2)));
    assertEquals("0,1", Utils.lnd(atn.addTwoNumbers(Utils.lns("5"), Utils.lns("5"))));
    assertEquals("1,8", Utils.lnd(atn.addTwoNumbers(Utils.lns("1,8"), Utils.lns("0"))));
  }
}
