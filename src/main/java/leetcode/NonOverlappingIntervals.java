package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
  public int eraseOverlapIntervals(Interval[] intervals) {
    if (intervals.length == 0) return 0;
    Arrays.sort(
        intervals,
        new Comparator<Interval>() {
          @Override
          public int compare(Interval o1, Interval o2) {
            if (o1.end == o2.end) {
              return Integer.compare(o2.start, o1.start);
            }
            return Integer.compare(o1.end, o2.end);
          }
        });
    int ans = 0;
    Interval prev = intervals[0];
    for (int i = 1; i < intervals.length; ++i) {
      Interval cur = intervals[i];
      if (cur.start < prev.end) {
        ans++;
      } else {
        prev = cur;
      }
    }
    return ans;
  }
}
