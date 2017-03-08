package leetcode;

public class ReverseSubLinkedList {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode subHead = dummy;
        int k = 1;
        while (k++ < m) {
            subHead = subHead.next;
        }
        ListNode iter = subHead.next;
        while (m++ < n) {
            ListNode temp = iter.next;
            iter.next = temp.next;
            temp.next = subHead.next;
            subHead.next = temp;
        }
        return dummy.next;
    }
}
