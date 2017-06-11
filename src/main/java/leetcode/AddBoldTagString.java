package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddBoldTagString {
  private static class Interval implements Comparable<Interval> {
    int start;
    int end;

    Interval(int start, int end) {
      this.start = start;
      this.end = end;
    }

    @Override
    public int compareTo(Interval o) {
      if (start == o.start) {
        return Integer.compare(end, o.end);
      }
      return Integer.compare(start, o.start);
    }
  }

  public String addBoldTag(String s, String[] dict) {
    List<Interval> intervals = new ArrayList<>();
    for (String d : dict) {
      for (int i = 0; i <= s.length() - d.length(); ++i) {
        if (d.equals(s.substring(i, i + d.length()))) {
          intervals.add(new Interval(i, i + d.length()));
        }
      }
    }
    if (intervals.size() == 0) {
      return s;
    }
    Collections.sort(intervals);
    StringBuilder sb = new StringBuilder();
    int finished = 0;
    for (int i = 0; i < intervals.size(); ) {
      int start = intervals.get(i).start;
      int end = intervals.get(i).end;

      while (i + 1 < intervals.size() && intervals.get(i + 1).start <= end) {
        ++i;
        end = Math.max(end, intervals.get(i).end);
      }
      // System.out.printf("i = %d, %d, %d\n", i, start, end);
      sb.append(s.substring(finished, start));
      sb.append("<b>");
      sb.append(s.substring(start, end));
      sb.append("</b>");
      finished = end;
      ++i;
    }
    sb.append(s.substring(finished));
    return sb.toString();
  }
}
