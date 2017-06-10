package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountSmallerNumbersAfterSelf {
  public List<Integer> countSmaller(int[] nums) {
    List<Integer> result = new ArrayList<>(Collections.nCopies(nums.length, 0));
    int[] indices = new int[nums.length];
    for (int i = 0; i < nums.length; ++i) {
      indices[i] = i;
    }
    mergeSort(nums, result, indices, 0, nums.length - 1);
    return result;
  }

  private void mergeSort(int[] nums, List<Integer> result, int[] indices, int start, int end) {
    if (start >= end) return;
    int mid = start + (end - start) / 2 + 1;
    mergeSort(nums, result, indices, start, mid - 1);
    mergeSort(nums, result, indices, mid, end);

    // Merge part
    int[] temp = new int[end - start + 1];
    int[] newIndices = new int[end - start + 1];
    int cnt = 0;
    int l = start;
    int r = mid;
    int writeIdx = 0;
    while (l < mid || r <= end) {
      if (l == mid) {
        temp[writeIdx] = nums[r];
        newIndices[writeIdx] = indices[r];
        ++r;
        ++writeIdx;
        ++cnt;
      } else if (r == end + 1) {
        temp[writeIdx] = nums[l];
        result.set(indices[l], result.get(indices[l]) + cnt);
        newIndices[writeIdx] = indices[l];
        ++writeIdx;
        ++l;
      } else {
        if (nums[l] <= nums[r]) {
          temp[writeIdx] = nums[l];
          result.set(indices[l], result.get(indices[l]) + cnt);
          newIndices[writeIdx] = indices[l];
          ++writeIdx;
          ++l;
        } else {
          temp[writeIdx] = nums[r];
          ++cnt;
          newIndices[writeIdx] = indices[r];
          ++writeIdx;
          ++r;
        }
      }
    }
    for (int i = 0; i < writeIdx; ++i) {
      nums[i + start] = temp[i];
      indices[i + start] = newIndices[i];
    }
  }
}
