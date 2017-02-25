package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by taku on 7/12/16.
 */
public class TopkFrequentElements {
    private class Elements implements Comparable<Elements> {
        public int val;
        public int count;
        Elements(int val, int count) {
            this.val = val;
            this.count = count;
        }

        @Override
        public boolean equals(Object other) {
            if (other instanceof Elements) {
                return val == ((Elements) other).val;
            }
            return false;
        }

        @Override
        public int compareTo(Elements other) {
            if (val == other.val) return 0;
            else if (val < other.val){
                if (count == other.count) return -1;
                else if (count < other.count) return 1;
                else return -1;
            } else {
                if (count == other.count) return 1;
                else if (count < other.count) return 1;
                else return -1;
            }
        }

    }

    public List<Integer> topKFrequent(List<Integer> nums, int k) {
        SortedSet<Elements> tree = new TreeSet<>();
        Map<Integer, Elements> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                Elements e = map.get(num);
                tree.remove(e);
                e.count += 1;
                tree.add(e);
            } else {
                Elements e = new Elements(num, 1);
                map.put(num, e);
                tree.add(e);
            }
//            System.out.println(tree.stream().map((e) -> String.valueOf(e.val)).collect(Collectors.joining(",")));
        }

        int count = 0;
        List<Integer> l = new LinkedList<>();
        for (Elements e : tree) {
            l.add(e.val);
            count += 1;
            if (count == k) break;
        }
        return l;
    }
}
