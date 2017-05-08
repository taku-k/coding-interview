package leetcode;

import java.util.*;

public class RandomPickIndex {
  private Map<Integer, List<Integer>> indicesOf;
  private Random gen;

  public RandomPickIndex(int[] nums) {
    indicesOf = new HashMap<>();
    gen = new Random();
    for (int i = 0; i < nums.length; ++i) {
      indicesOf.putIfAbsent(nums[i], new ArrayList<>());
      indicesOf.get(nums[i]).add(i);
    }
  }

  public int pick(int target) {
    List<Integer> indices = indicesOf.get(target);
    return indices.get(gen.nextInt(indices.size()));
  }
}
