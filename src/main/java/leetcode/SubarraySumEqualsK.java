package leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
  public int subarraySum(int[] nums, int k) {
    Map<Integer, Integer> cnt = new HashMap<>();
    int sum = 0;
    cnt.put(0, 1);
    int res = 0;
    for (int i = 0; i < nums.length; ++i) {
      sum += nums[i];
      if (cnt.containsKey(sum - k)) {
        res += cnt.get(sum - k);
      }
      cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
    }
    return res;
  }
}
