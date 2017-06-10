package epi.ch14;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.junit.Test;

public class MinimumDistanceSortedArraysTest {
  @Test
  public void test() {
    Random r = new Random();
    for (int tcase = 0; tcase < 100; ++tcase) {
      int n = r.nextInt(5) + 1;
      List<List<Integer>> sortedArrays = new ArrayList<>();
      for (int i = 0; i < n; ++i) {
        int size = r.nextInt(40) + 1;
        sortedArrays.add(new ArrayList<>(size));
        for (int j = 0; j < size; ++j) {
          sortedArrays.get(i).add(r.nextInt(10000));
        }
        Collections.sort(sortedArrays.get(i));
      }
      int answer = MinimumDistanceSortedArrays.findMinDistanceSortedArrays(sortedArrays);
      int actual = bruteForceGenAnswer(sortedArrays);
      //      System.out.printf("actual = %d, ans = %s\n", actual, answer);
      assertEquals(actual, answer);
    }
  }

  private static Integer ans;

  private static void recGenAnswer(List<List<Integer>> sortedArrays, List<Integer> idx, int level) {
    if (level == sortedArrays.size()) {
      ans = Math.min(distance(sortedArrays, idx), ans);
      return;
    }
    for (int i = 0; i < sortedArrays.get(level).size(); ++i) {
      idx.set(level, i);
      recGenAnswer(sortedArrays, idx, level + 1);
    }
  }

  private static int bruteForceGenAnswer(List<List<Integer>> sortedArrays) {
    List<Integer> idx = new ArrayList<>(sortedArrays.size());
    for (List<Integer> arr : sortedArrays) {
      idx.add(0);
    }
    ans = Integer.MAX_VALUE;
    recGenAnswer(sortedArrays, idx, 0);
    //    System.out.println(ans);
    return ans;
  }

  private static int distance(List<List<Integer>> sortedArrays, List<Integer> idx) {
    int maxVal = Integer.MIN_VALUE;
    int minVal = Integer.MAX_VALUE;
    for (int i = 0; i < idx.size(); ++i) {
      maxVal = Math.max(maxVal, sortedArrays.get(i).get(idx.get(i)));
      minVal = Math.min(minVal, sortedArrays.get(i).get(idx.get(i)));
    }
    return maxVal - minVal;
  }
}
