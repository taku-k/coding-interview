package leetcode;

import java.util.Arrays;

public class TwoSum2 {
  public int[] twoSum(int[] numbers, int target) {
    int len = numbers.length;
    int[] result = null;
    for (int i = 0; i < len; ++i) {
      int j = Arrays.binarySearch(numbers, i + 1, len, target - numbers[i]);
      if (j >= 0) {
        result = new int[] {i + 1, j + 1};
        break;
      }
    }
    return result;
  }
}
