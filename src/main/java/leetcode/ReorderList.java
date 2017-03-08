package leetcode;

public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode subHead = slow;
        ListNode iter = subHead.next;
        while (iter.next != null) {
            ListNode temp = iter.next;
            iter.next = temp.next;
            temp.next = subHead.next;
            subHead.next = temp;
        }

        ListNode first = head;
        ListNode second = slow.next;
        ListNode middle = slow;
        while (first != middle) {
            middle.next = second.next;
            second.next = first.next;
            first.next = second;
            first = second.next;
            second = middle.next;
        }
    }
}
