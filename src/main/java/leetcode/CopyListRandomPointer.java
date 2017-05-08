package leetcode;

import java.util.HashMap;
import java.util.Map;

public class CopyListRandomPointer {

  public RandomListNode copyRandomList(RandomListNode head) {
    Map<RandomListNode, RandomListNode> oldToNew = new HashMap<>();
    RandomListNode dummy = new RandomListNode(0);
    RandomListNode tail = dummy;
    RandomListNode iter = head;
    while (iter != null) {
      tail.next = new RandomListNode(iter.label);
      oldToNew.put(iter, tail.next);
      iter = iter.next;
      tail = tail.next;
    }
    iter = head;
    tail = dummy.next;
    while (iter != null) {
      RandomListNode newNode = oldToNew.get(iter.random);
      tail.random = newNode;
      iter = iter.next;
      tail = tail.next;
    }
    return dummy.next;
  }
}
