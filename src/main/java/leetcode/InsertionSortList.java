package leetcode;

public class InsertionSortList {

  public ListNode insertionSortList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode target = head.next;
    ListNode prevTarget = head;
    while (target != null) {
      ListNode curTarget = target;
      target = target.next;
      ListNode prev = dummy, iter = dummy.next;
      while (iter != curTarget) {
        if (iter.val > curTarget.val) {
          prev.next = curTarget;
          prevTarget.next = target;
          curTarget.next = iter;
          break;
        }
        prev = prev.next;
        iter = iter.next;
      }
      if (prevTarget.next != target) {
        prevTarget = prevTarget.next;
      }
    }
    return dummy.next;
  }
}
