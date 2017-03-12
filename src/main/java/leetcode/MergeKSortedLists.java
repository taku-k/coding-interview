package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    private class ListEntry {
        public int value;
        public ListNode node;
        public ListEntry(int value, ListNode node) {
            this.value = value;
            this.node = node;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if (k == 0) return null;
        PriorityQueue<ListEntry> minHeap = new PriorityQueue<>(k, new Comparator<ListEntry>() {
            @Override
            public int compare(ListEntry o1, ListEntry o2) {
                return Integer.compare(o1.value, o2.value);
            }
        });
        for (int i = 0; i < k; ++i) {
            if (lists[i] != null) {
                minHeap.add(new ListEntry(lists[i].val, lists[i]));
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (!minHeap.isEmpty()) {
            ListEntry entry = minHeap.poll();
            head.next = entry.node;
            if (entry.node.next != null) {
                minHeap.add(new ListEntry(entry.node.next.val, entry.node.next));
            }
            head = head.next;
        }
        return dummy.next;
    }
}
