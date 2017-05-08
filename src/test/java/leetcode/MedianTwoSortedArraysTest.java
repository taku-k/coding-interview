package leetcode;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/** Created by taku on 2016/05/25. */
public class MedianTwoSortedArraysTest {
  MedianTwoSortedArrays mts;

  @Before
  public void setUp() throws Exception {
    this.mts = new MedianTwoSortedArrays();
  }

  @Test
  public void findMedianSortedArrays() throws Exception {
    assertEquals(
        16.0,
        mts.findMedianSortedArrays(new int[] {1, 12, 15, 26, 38}, new int[] {2, 13, 17, 30, 45}),
        1.0e-3);
    assertEquals(
        5.5,
        mts.findMedianSortedArrays(new int[] {1, 2, 3, 4, 5}, new int[] {6, 7, 8, 9, 10}),
        1.0e-3);
    assertEquals(1.0, mts.findMedianSortedArrays(new int[] {}, new int[] {1}), 1.0e-3);
    assertEquals(5.0, mts.findMedianSortedArrays(new int[] {3}, new int[] {1, 5, 8, 9}), 1.0e-3);
    assertEquals(3.5, mts.findMedianSortedArrays(new int[] {1, 3}, new int[] {2, 4, 8, 9}), 1.0e-3);
  }
}
