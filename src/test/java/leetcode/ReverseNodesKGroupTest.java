package leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseNodesKGroupTest {
    @Test
    public void reverseKGroup() throws Exception {
        ReverseNodesKGroup inst = new ReverseNodesKGroup();
        ListNode l = Utils.lns("1,2,3,4,5");
        assertEquals("2,1,4,3,5", Utils.lnd(inst.reverseKGroup(l, 2)));
        l = Utils.lns("1,2,3,4,5");
        assertEquals("3,2,1,4,5", Utils.lnd(inst.reverseKGroup(l, 3)));
        l = Utils.lns("1,2,3,4,5");
        assertEquals("1,2,3,4,5", Utils.lnd(inst.reverseKGroup(l, 1)));
        assertEquals("", Utils.lnd(inst.reverseKGroup(null, 1)));
    }
}