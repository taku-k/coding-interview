package leetcode;

import java.util.Arrays;

public class CombinationSum4 {
  public int combinationSum4(int[] nums, int target) {
    int[] dp = new int[target + 1];
    Arrays.fill(dp, -1);
    dp[0] = 1;
    return helper(dp, nums, target);
  }

  private int helper(int[] dp, int[] nums, int target) {
    if (dp[target] != -1) {
      return dp[target];
    }
    int res = 0;
    for (int i = 0; i < nums.length; ++i) {
      if (target >= nums[i]) {
        res += helper(dp, nums, target - nums[i]);
      }
    }
    dp[target] = res;
    return res;
  }
}
