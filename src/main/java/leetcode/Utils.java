package leetcode;

import java.util.*;
import java.io.*;
import java.lang.*;

/**
 * Created by taku on 2016/05/25.
 */
public class Utils {
    static ListNode lns(String s) {
        String[] splited = s.split(",");
        ListNode head = new ListNode(Integer.parseInt(splited[0]));
        ListNode tmp = head;
        for (int i = 1; i < splited.length; i++) {
            tmp.next = new ListNode(Integer.parseInt(splited[i]));
            tmp = tmp.next;
        }
        return head;
    }

    static String lnd(ListNode head) {
        List<String> l = new ArrayList<>();
        while (head != null) {
            l.add(Integer.toString(head.val));
            head = head.next;
        }
        return String.join(",", (String [])l.toArray(new String[l.size()]));
    }
}
