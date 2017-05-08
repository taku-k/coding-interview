package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
  public List<Interval> merge(List<Interval> intervals) {
    List<Interval> result = new ArrayList<>();
    if (intervals.size() == 0) return result;
    Collections.sort(
        intervals,
        new Comparator<Interval>() {
          @Override
          public int compare(Interval o1, Interval o2) {
            if (o1.start != o2.start) {
              return Integer.compare(o1.start, o2.start);
            }
            return Integer.compare(o1.end, o2.end);
          }
        });
    Interval cur = intervals.get(0);
    for (int i = 1; i < intervals.size(); ++i) {
      Interval next = intervals.get(i);
      if (next.start <= cur.end) {
        // overlapping
        if (next.end > cur.end) {
          cur.end = next.end;
        }
      } else {
        result.add(cur);
        cur = next;
      }
    }
    result.add(cur);
    return result;
  }
}
