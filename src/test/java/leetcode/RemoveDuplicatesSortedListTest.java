package leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveDuplicatesSortedListTest {
    @Test
    public void deleteDuplicates() throws Exception {
        ListNode h = Utils.lns("1,1,2");
        ListNode actual = RemoveDuplicatesSortedList.deleteDuplicates(h);
        assertEquals("1,2", Utils.lnd(actual));

        h = Utils.lns("1,1,2,3,3");
        actual = RemoveDuplicatesSortedList.deleteDuplicates(h);
        assertEquals("1,2,3", Utils.lnd(actual));
    }
}