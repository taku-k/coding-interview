package cracking_the_coding_interview;

/** Created by taku on 2016/05/07. */
public class Problem2_2 {
  static int takekNode(Node n, int k) {
    Node head = n;
    Node tail = n;
    for (int i = 0; i < k - 1; i++) {
      head = head.next;
      if (head == null) {
        return 0;
      }
    }

    while (head.next != null) {
      head = head.next;
      tail = tail.next;
    }
    return tail.data;
  }
}
