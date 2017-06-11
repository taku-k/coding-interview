package leetcode;

import java.util.Arrays;

public class ValidTriangleNumber {
  public int triangleNumber(int[] nums) {
    Arrays.sort(nums);
    int res = 0;
    int n = nums.length;
    for (int i = 0; i < n - 2; ++i) {
      for (int j = i + 1; j < n - 1; ++j) {
        int target = nums[i] + nums[j] - 1;
        int l = j + 1;
        int r = n;
        while (l < r) {
          int mid = l + (r - l) / 2;
          if (nums[mid] > target) {
            r = mid;
          } else {
            l = mid + 1;
          }
        }
        res += (l - j - 1);
      }
    }
    return res;
  }
}
