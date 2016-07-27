package cracking_the_coding_interview;

import java.lang.*;
import java.util.*;

class Problem2_1 {
    public static void dropDuplicates(Node n) {
        Set<Integer> check = new HashSet<>();
        Node prev = n;
        check.add(n.data);
        while (n.next != null) {
            if (check.contains(n.data)) {
                prev.next = n.next;
            } else {
                prev = n;
                check.add(n.data);
            }
            n = n.next;
        }
    }
}