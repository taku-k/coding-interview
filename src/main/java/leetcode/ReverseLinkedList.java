package leetcode;

public class ReverseLinkedList {

  public static ListNode reverseList(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode iter = dummy.next;
    while (iter.next != null) {
      ListNode temp = iter.next;
      iter.next = temp.next;
      temp.next = dummy.next;
      dummy.next = temp;
    }
    return dummy.next;
  }
}
