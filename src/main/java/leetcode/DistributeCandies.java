package leetcode;

import java.util.Arrays;

public class DistributeCandies {
  public int distributeCandies(int[] candies) {
    int result = candies.length / 2;
    int cnt = (int) Arrays.stream(candies).distinct().count();
    return Math.min(result, cnt);
  }
}
