package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {
  public int findLHS(int[] nums) {
    Map<Integer, Integer> counts = new HashMap<>();
    int result = 0;
    for (int n : nums) {
      counts.put(n, counts.getOrDefault(n, 0) + 1);
    }
    for (Map.Entry<Integer, Integer> e : counts.entrySet()) {
      if (e.getKey() == Integer.MAX_VALUE) continue;
      if (counts.containsKey(e.getKey() + 1)) {
        result = Math.max(result, e.getValue() + counts.get(e.getKey() + 1));
      }
    }
    return result;
  }
}
