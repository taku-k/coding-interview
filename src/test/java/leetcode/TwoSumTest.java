package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

/** Created by taku on 2016/05/25. */
public class TwoSumTest {
  @Test
  public void twoSum() throws Exception {
    TwoSum ts = new TwoSum();
    assertArrayEquals(new int[] {0, 1}, ts.twoSum(new int[] {2, 7, 11, 15}, 9));
    assertArrayEquals(new int[] {1, 2}, ts.twoSum(new int[] {3, 2, 4}, 6));
  }

  @Test
  public void twoSumFast() throws Exception {
    TwoSum ts = new TwoSum();
    assertArrayEquals(new int[] {0, 1}, ts.twoSumFast(new int[] {2, 7, 11, 15}, 9));
    assertArrayEquals(new int[] {1, 2}, ts.twoSumFast(new int[] {3, 2, 4}, 6));
  }
}
