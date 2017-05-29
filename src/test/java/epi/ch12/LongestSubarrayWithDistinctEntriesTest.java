package epi.ch12;

import static epi.ch12.LongestSubarrayWithDistinctEntries.longestSubarrayWithDistinctEntries;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.junit.Test;

public class LongestSubarrayWithDistinctEntriesTest {
  @Test
  public void simpleTest() {
    assertEquals(1, longestSubarrayWithDistinctEntries(Arrays.asList(1, 1, 1)));
    assertEquals(2, longestSubarrayWithDistinctEntries(Arrays.asList(1, 2, 1)));
    assertEquals(3, longestSubarrayWithDistinctEntries(Arrays.asList(1, 2, 1, 3, 1, 2, 1)));
    assertEquals(2, longestSubarrayWithDistinctEntries(Arrays.asList(1, 2, 2, 3, 3, 1, 1, 2, 1)));
  }

  @Test
  public void test() {
    Random r = new Random();
    int n = r.nextInt(1001);

    for (int times = 0; times < 1000; ++times) {
      List<Integer> A = new ArrayList<>(n);
      for (int i = 0; i < n; i++) {
        A.add(r.nextInt(1001));
      }
      // System.out.println(A);
      int ans = longestSubarrayWithDistinctEntries(A);
      int goldenAns = checkAns(A);
      assertTrue(ans == goldenAns);
    }
  }

  private static int checkAns(List<Integer> A) {
    int len = 0;
    for (int i = 0; i < A.size(); ++i) {
      Set<Integer> table = new HashSet<>();
      int j;
      for (j = i; A.size() - i > len && j < A.size(); ++j) {
        if (!table.add(A.get(j))) {
          break;
        }
      }
      len = Math.max(len, j - i);
    }
    return len;
  }
}
