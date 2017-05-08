package leetcode;

public class SortList {

  /** Sort linked list based on merge sort */
  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode slow, fast, tail;
    slow = fast = tail = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    while (tail.next != slow) {
      tail = tail.next;
    }
    tail.next = null;
    ListNode left = sortList(head);
    ListNode right = sortList(slow);

    // Merge part
    ListNode dummy = new ListNode(0);
    ListNode iter = dummy;
    while (left != null && right != null) {
      if (left.val <= right.val) {
        iter.next = left;
        left = left.next;
      } else {
        iter.next = right;
        right = right.next;
      }
      iter = iter.next;
    }
    iter.next = left == null ? right : left;
    return dummy.next;
  }
}
