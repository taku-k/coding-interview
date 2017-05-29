package epi.ch12;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestContainedRange {
  public static int findLongestContainedRangeInt(List<Integer> A) {
    Set<Integer> candidates = new HashSet<>();
    int result = 0;
    for (int a : A) {
      candidates.add(a);
    }
    while (!candidates.isEmpty()) {
      int a = candidates.iterator().next();
      int cnt = 1;
      candidates.remove(a);
      int upper = a + 1, lower = a - 1;
      while (candidates.contains(upper)) {
        candidates.remove(upper++);
        ++cnt;
      }
      while (candidates.contains(lower)) {
        candidates.remove(lower--);
        ++cnt;
      }
      result = Math.max(result, cnt);
    }
    return result;
  }
}
