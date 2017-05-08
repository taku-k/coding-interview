package leetcode;

import java.util.Random;

public class ShuffleArray {
  private int[] nums;

  public ShuffleArray(int[] nums) {
    this.nums = nums;
  }

  public int[] reset() {
    return nums;
  }

  public int[] shuffle() {
    if (nums == null) return null;
    int[] copy = nums.clone();
    Random r = new Random();
    for (int i = 0; i < nums.length; ++i) {
      swap(nums, i, i + r.nextInt(nums.length - i));
    }
    return copy;
  }

  private void swap(int[] a, int i, int j) {
    int tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
  }
}
