package leetcode;

public class RotateList {
    public static ListNode rotateRight(ListNode head, int k) {
        if (k == 0) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode iter = dummy;
        ListNode last = dummy.next;
        int len = 0;
        while (iter.next != null) {
            ++len;
            iter = iter.next;
            last = iter;
        }
        if (len == 0) {
            return head;
        }
        k = k % len;
        k = len - k;
        if (k == len) {
            return head;
        }
        iter = dummy;
        while (k-- > 0) {
            iter = iter.next;
        }
        ListNode newHead = iter.next;
        ListNode newTail = iter;
        newTail.next = null;
        last.next = dummy.next;
        dummy.next = newHead;
        return dummy.next;
    }
}
