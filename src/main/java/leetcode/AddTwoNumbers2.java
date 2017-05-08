package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class AddTwoNumbers2 {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    Deque<Integer> s1 = new LinkedList<>();
    Deque<Integer> s2 = new LinkedList<>();
    while (l1 != null) {
      s1.addFirst(l1.val);
      l1 = l1.next;
    }
    while (l2 != null) {
      s2.addFirst(l2.val);
      l2 = l2.next;
    }

    ListNode dummy = new ListNode(0);
    int carryin = 0, v1 = 0, v2 = 0;
    while (!s1.isEmpty() || !s2.isEmpty()) {
      if (s1.isEmpty()) {
        v1 = 0;
      } else {
        v1 = s1.pollFirst();
      }
      if (s2.isEmpty()) {
        v2 = 0;
      } else {
        v2 = s2.pollFirst();
      }
      int c = (v1 + v2 + carryin) % 10;
      int carryout = (v1 + v2 + carryin) / 10;
      ListNode temp = new ListNode(c);
      temp.next = dummy.next;
      dummy.next = temp;
      carryin = carryout;
    }
    if (carryin != 0) {
      ListNode temp = new ListNode(carryin);
      temp.next = dummy.next;
      dummy.next = temp;
    }
    return dummy.next;
  }
}
