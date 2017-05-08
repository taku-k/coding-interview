package leetcode;

public class RemoveDuplicatesSortedList2 {

  public ListNode deleteDuplicates(ListNode head) {
    ListNode dummy = new ListNode(0);
    ListNode distinct = dummy;
    while (head != null) {
      if (head.next == null || head.val != head.next.val) {
        distinct.next = head;
        distinct = head;
        head = head.next;
      } else {
        int x = head.val;
        while (head != null && head.val == x) {
          head = head.next;
        }
      }
    }
    return dummy.next;
  }
}
