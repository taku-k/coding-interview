package leetcode;

public class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode adv = dummy, iter = dummy;
        while (n-- > 0) {
            adv = adv.next;
        }
        while (adv.next != null) {
            adv = adv.next;
            iter = iter.next;
        }
        iter.next = iter.next.next;
        return dummy.next;
    }
}
