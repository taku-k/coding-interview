package leetcode;

public class PalindromeLinkedList {
  private ListNode reverse(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode iter = dummy.next;
    while (iter != null && iter.next != null) {
      ListNode temp = iter.next;
      iter.next = temp.next;
      temp.next = dummy.next;
      dummy.next = temp;
    }
    return dummy.next;
  }

  public boolean isPalindrome(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    slow = reverse(slow);
    ListNode iter = slow;
    while (head != null && iter != null) {
      if (head.val != iter.val) {
        return false;
      }
      head = head.next;
      iter = iter.next;
    }
    return true;
  }
}
