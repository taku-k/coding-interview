package leetcode;

public class IntersectionTwoLinkedList {
  public int getLength(ListNode l) {
    int len = 0;
    while (l != null) {
      ++len;
      l = l.next;
    }
    return len;
  }

  public ListNode advanceListByK(ListNode l, int k) {
    while (k-- > 0) {
      l = l.next;
    }
    return l;
  }

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    int lenA = getLength(headA), lenB = getLength(headB);
    int diff = Math.abs(lenA - lenB);
    if (lenA > lenB) {
      headA = advanceListByK(headA, diff);
    } else {
      headB = advanceListByK(headB, diff);
    }
    while (headA != null && headB != null) {
      if (headA == headB) {
        return headA;
      }
      headA = headA.next;
      headB = headB.next;
    }
    return null;
  }
}
