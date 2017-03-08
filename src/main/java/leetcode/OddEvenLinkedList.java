package leetcode;

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(0);
        ListNode even = new ListNode(0);
        ListNode oddDummyHead = odd;
        ListNode evenDummyHead = even;
        boolean flip = true;
        while (head != null) {
            if (flip) {
                odd.next = head;
                odd = odd.next;
            } else {
                even.next = head;
                even = even.next;
            }
            head = head.next;
            flip = !flip;
        }
        even.next = null;
        odd.next = evenDummyHead;
        return oddDummyHead.next;
    }
}
