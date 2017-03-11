package leetcode;

import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by taku on 2016/05/25.
 */
public class Utils {
    static ListNode lns(String s) {
        if (s.equals("")) return null;
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

    static TreeNode toTreeNode(String data) {
        return new SerializeAndDeserializeBinaryTree().deserialize2(data);
    }

    static TreeNode toTreeNode(Integer ...data) {
        String s = Stream.of(data).map(i -> String.format("%d", i)).collect(Collectors.joining(","));
        return new SerializeAndDeserializeBinaryTree().deserialize(s);
    }
}
