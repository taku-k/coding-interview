package leetcode;

import java.util.HashMap;
import java.util.Map;

/** Created by taku on 2016/05/25. */
public class TwoSum {
  /*
   * Time complexity: O(n^2) where n is the length of nums
   * Space Complexity: O(1)
   */
  public int[] twoSum(int[] nums, int target) {
    int[] ret = new int[2];
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          ret[0] = i;
          ret[1] = j;
          break;
        }
      }
    }
    return ret;
  }

  public int[] twoSumFast(int[] nums, int target) {
    Map<Integer, Integer> m = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      m.put(nums[i], i);
    }
    for (int i = 0; i < nums.length; i++) {
      if (m.containsKey(target - nums[i]) && m.get(target - nums[i]) != i) {
        return new int[] {i, m.get(target - nums[i])};
      }
    }
    throw new IllegalArgumentException("No two sum solution");
  }
}
