package leetcode;

import java.util.*;

public class ThreeSum {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);
    Set<Integer> used = new HashSet<>();
    for (int i = 0; i < nums.length - 2; ++i) {
      if (used.contains(nums[i])) {
        continue;
      } else {
        used.add(nums[i]);
      }
      int j = i + 1, k = nums.length - 1;
      while (j < k) {
        int target = nums[i] + nums[j] + nums[k];
        if (target == 0) {
          res.add(Arrays.asList(nums[i], nums[j], nums[k]));
          while (j + 1 < k && nums[j] == nums[j + 1]) j++;
          while (j < k - 1 && nums[k] == nums[k - 1]) k--;
          j++;
          k--;
        } else if (target > 0) {
          k--;
        } else {
          j++;
        }
      }
    }
    return res;
  }
}
