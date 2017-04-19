package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinArrowShots {
    private class Interval implements Comparable<Interval> {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Interval o) {
            return Integer.compare(this.end, o.end);
        }
    }
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        List<Interval> intervals = new ArrayList<>();
        for (int[] point : points) {
            intervals.add(new Interval(point[0], point[1]));
        }
        Collections.sort(intervals);
        int ans = 1;
        int last = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); ++i) {
            Interval interval = intervals.get(i);
            if (interval.start > last) {
                last = interval.end;
                ans++;
            }
        }
        return ans;
    }
}
