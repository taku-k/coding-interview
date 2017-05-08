package leetcode;

public class ReverseNodesKGroup {

  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode iter = head, end = head, subHead = dummy;
    int cnt = 0;
    while (end != null) {
      cnt = 0;
      while (cnt < k && end != null) {
        end = end.next;
        ++cnt;
      }
      if (cnt != k) {
        break;
      }
      while (iter.next != end) {
        ListNode temp = iter.next;
        iter.next = temp.next;
        temp.next = subHead.next;
        subHead.next = temp;
      }
      subHead = iter;
      iter = iter.next;
    }
    return dummy.next;
  }
}
