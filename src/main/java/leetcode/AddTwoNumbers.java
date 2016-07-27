package leetcode;

import java.util.List;

/**
 * Created by taku on 2016/05/25.
 */
public class AddTwoNumbers {

    /*
     * Time complexity is O(max(m, n)) where m and n represents the length of l1 and l2 respectively.
     * Space Complexitiy is O(max(m, n))
     */

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode((l1.val + l2.val) % 10);
        ListNode node = head;
        int c = (l1.val + l2.val) / 10;
        l1 = l1.next;
        l2 = l2.next;

        while (l1 != null || l2 != null) {
            if (l1 == null) {
                node.next = new ListNode((l2.val + c) % 10);
                c = (l2.val + c) / 10;
                l2 = l2.next;
            } else if (l2 == null) {
                node.next = new ListNode((l1.val + c) % 10);
                c = (l1.val + c) / 10;
                l1 = l1.next;
            } else {
                int sum = l1.val + l2.val + c;
                node.next = new ListNode(sum % 10);
                c = sum / 10;
                l1 = l1.next;
                l2 = l2.next;
            }

            node = node.next;
        }

        if (c != 0) {
            node.next = new ListNode(c);
        }
        return head;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p, q, curr; p = l1; q = l2; curr = dummy;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = x + y + carry;
            curr.next = new ListNode(sum % 10);
            carry = sum / 10;
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }

        if (carry != 0) {
            curr.next = new ListNode(carry);
        }
        return dummy.next;
    }

    public ListNode nonReversed(ListNode l1, ListNode l2) {
        return null;
    }
}
