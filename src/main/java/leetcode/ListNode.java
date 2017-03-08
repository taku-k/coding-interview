package leetcode;

/**
 * Created by taku on 2016/05/25.
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    ListNode(int x, ListNode n) {
        val = x;
        next = n;
    }
}
