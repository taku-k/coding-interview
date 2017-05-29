package epi.ch12;

import static epi.ch12.LongestContainedRange.findLongestContainedRangeInt;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.junit.Test;

public class LongestContainedRangeTest {
  @Test
  public void test() {
    Random r = new Random();
    for (int times = 0; times < 1000; ++times) {
      int n = r.nextInt(10001);
      List<Integer> A = new ArrayList<>(n);
      for (int i = 0; i < n; ++i) {
        A.add(r.nextInt(n + 1));
      }

      assertEquals(findLongestContainedRangeInt(A), checkAns(A));
    }
  }

  private static int checkAns(List<Integer> A) {
    if (A.size() == 0) return 0;
    Collections.sort(A);
    int result = 1;
    int pre = A.get(0), len = 1;
    for (int i = 1; i < A.size(); ++i) {
      if (A.get(i) == pre + 1) {
        ++len;
      } else if (A.get(i) != pre) {
        result = Math.max(result, len);
        len = 1;
      }
      pre = A.get(i);
    }
    result = Math.max(result, len);
    return result;
  }
}
