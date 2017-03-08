package leetcode;

public class RemoveDuplicatesSortedList {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode iter = dummy.next;
        while (iter != null) {
            int x = iter.val;
            ListNode inner = iter.next;
            while (inner != null && inner.val == x) {
                inner = inner.next;
            }
            iter.next = inner;
            iter = inner;
        }
        return dummy.next;
    }
}
