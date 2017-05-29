package epi.ch12;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestSubarrayWithDistinctEntries {
  public static int longestSubarrayWithDistinctEntries(List<Integer> A) {
    int left = 0, right = 0;
    Set<Integer> set = new HashSet<>();
    int result = Integer.MIN_VALUE;
    while (right < A.size()) {
      int x = A.get(right);
      if (set.contains(x)) {
        while (A.get(left) != x) {
          set.remove(A.get(left++));
        }
        ++left;
      } else {
        set.add(x);
        result = Math.max(result, set.size());
      }
      ++right;
    }
    return result;
  }
}
