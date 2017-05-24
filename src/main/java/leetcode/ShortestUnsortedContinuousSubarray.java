package leetcode;

public class ShortestUnsortedContinuousSubarray {
  public int findUnsortedSubarray(int[] nums) {
    int lower = -2, upper = -1;
    int min = Integer.MAX_VALUE;
    for (int i = nums.length - 1; i >= 0; --i) {
      min = Math.min(min, nums[i]);
      if (nums[i] > min) lower = i;
    }
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; ++i) {
      max = Math.max(max, nums[i]);
      if (nums[i] < max) upper = i;
    }
    return upper - lower - 1;
  }
}
