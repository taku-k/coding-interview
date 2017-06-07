package leetcode;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate2 {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    int end = 0;
    Set<Integer> win = new HashSet<>();
    for (; end <= k && end < nums.length; ++end) {
      if (win.contains(nums[end])) {
        return true;
      }
      win.add(nums[end]);
    }
    int start = 0;
    for (; end < nums.length; ++end) {
      win.remove(nums[start]);
      if (win.contains(nums[end])) {
        return true;
      }
      win.add(nums[end]);
      ++start;
    }
    return false;
  }
}
