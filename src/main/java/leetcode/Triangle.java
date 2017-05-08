package leetcode;

import java.util.Collections;
import java.util.List;

public class Triangle {
  public int minimumTotal(List<List<Integer>> triangle) {
    if (triangle.size() == 0) return 0;
    List<Integer> prev = triangle.get(0);
    for (int i = 1; i < triangle.size(); ++i) {
      List<Integer> curr = triangle.get(i);
      curr.set(0, curr.get(0) + prev.get(0));
      for (int j = 1; j < curr.size() - 1; ++j) {
        curr.set(j, curr.get(j) + Math.min(prev.get(j - 1), prev.get(j)));
      }
      curr.set(curr.size() - 1, curr.get(curr.size() - 1) + prev.get(curr.size() - 2));
      prev = curr;
    }
    return Collections.min(prev);
  }
}
