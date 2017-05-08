package leetcode;

/** Created by taku on 7/11/16. */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */
public class MergeTwoSortedLists {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    } else if (l2 == null) {
      return l1;
    }
    ListNode ret = null;
    ListNode curl2 = l2;
    ListNode curl1 = l1;
    ListNode prev = null;
    while (curl2 != null) {
      if (curl2.val < curl1.val) {
        ListNode tmp = curl2.next;
        curl2.next = curl1;
        curl1 = curl2;
        curl2 = tmp;
        if (prev != null) {
          prev.next = curl1;
        } else {
          ret = curl1;
        }
      } else {
        if (prev != null) {
          prev = prev.next;
        } else {
          ret = curl1;
          prev = curl1;
        }
        if (curl1.next == null) {
          curl1.next = curl2;
          break;
        } else {
          curl1 = curl1.next;
        }
      }
    }
    return ret;
  }
}
