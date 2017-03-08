package leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseLinkedListTest {
    @Test
    public void reverseList() throws Exception {
        ListNode h = Utils.lns("1,2,3");
        ListNode actual = ReverseLinkedList.reverseList(h);
        assertEquals("3,2,1", Utils.lnd(actual));
    }
}