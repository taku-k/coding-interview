package leetcode;

public class SwapNodesPairs {

  public ListNode swapPairs(ListNode head) {
    ListNode fast = head;
    ListNode subHead = new ListNode(0);
    subHead.next = head;
    while (fast != null && fast.next != null) {
      ListNode temp = fast.next;
      fast.next = temp.next;
      temp.next = subHead.next;
      subHead.next = temp;
      fast = fast.next.next;
      subHead = subHead.next.next;
    }
    return head;
  }
}
