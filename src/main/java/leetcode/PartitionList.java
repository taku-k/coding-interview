package leetcode;

public class PartitionList {

  public ListNode partition(ListNode head, int x) {
    ListNode lessDummy = new ListNode(0);
    ListNode greaterDummy = new ListNode(0);
    ListNode less = new ListNode(0);
    ListNode greaterEq = new ListNode(0);
    lessDummy.next = less;
    greaterDummy.next = greaterEq;
    while (head != null) {
      if (head.val < x) {
        less.next = head;
        less = less.next;
      } else {
        greaterEq.next = head;
        greaterEq = greaterEq.next;
      }
      head = head.next;
    }
    less.next = greaterDummy.next.next;
    return lessDummy.next.next;
  }
}
