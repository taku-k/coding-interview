package leetcode;

import java.util.Random;

public class KthLargestUnsortedArray {
  public int findKthLargest(int[] nums, int k) {
    int left = 0, right = nums.length - 1;
    Random r = new Random();
    while (left <= right) {
      int pivotIdx = r.nextInt(right - left + 1) + left;
      int newPivotIdx = partition(nums, left, right, pivotIdx);
      if (newPivotIdx == k - 1) {
        return nums[newPivotIdx];
      } else if (newPivotIdx > k - 1) {
        right = newPivotIdx - 1;
      } else {
        left = newPivotIdx + 1;
      }
    }
    return -1;
  }

  private int partition(int[] nums, int left, int right, int pivotIdx) {
    int pivotVal = nums[pivotIdx];
    swap(nums, pivotIdx, right);
    int larger = left;
    for (int i = left; i < right; ++i) {
      if (nums[i] > pivotVal) {
        swap(nums, i, larger++);
      }
    }
    swap(nums, larger, right);
    return larger;
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
