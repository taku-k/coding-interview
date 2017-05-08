package leetcode;

public class LinkedListCycleDetect {
  public ListNode detectCycle(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) {
        int cycleLen = 0;
        do {
          ++cycleLen;
          fast = fast.next;
        } while (fast != slow);
        ListNode adv = head;
        while (cycleLen-- > 0) {
          adv = adv.next;
        }
        ListNode iter = head;
        while (adv != iter) {
          adv = adv.next;
          iter = iter.next;
        }
        return iter;
      }
    }
    return null;
  }
}
