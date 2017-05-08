package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> numsList = new ArrayList<>();
    for (int i : nums) {
      numsList.add(i);
    }
    helper(0, numsList, result);
    return result;
  }

  private void helper(int i, List<Integer> nums, List<List<Integer>> result) {
    if (i == nums.size() - 1) {
      result.add(new ArrayList<>(nums));
      return;
    }
    for (int j = i; j < nums.size(); ++j) {
      Collections.swap(nums, i, j);
      helper(i + 1, nums, result);
      Collections.swap(nums, i, j);
    }
  }
}
