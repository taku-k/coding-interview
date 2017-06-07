package leetcode;

import java.util.NavigableSet;
import java.util.TreeSet;

public class ContainsDuplicate3 {
  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    NavigableSet<Integer> win = new TreeSet<>();
    int end = 0;
    for (; end <= k && end < nums.length; ++end) {
      if (check(win, nums[end], t)) {
        return true;
      }
      win.add(nums[end]);
    }
    int start = 0;
    for (; end < nums.length; ++end) {
      win.remove(nums[start]);
      if (check(win, nums[end], t)) {
        return true;
      }
      win.add(nums[end]);
      ++start;
    }
    return false;
  }

  private boolean check(NavigableSet<Integer> win, int n, int t) {
    Integer h = win.ceiling(n);
    Integer s = win.floor(n);
    if (s != null) {
      if ((long) n - (long) s <= t) {
        return true;
      }
    }
    if (h != null) {
      if ((long) h - (long) n <= t) {
        return true;
      }
    }
    return false;
  }
}
