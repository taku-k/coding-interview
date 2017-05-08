package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

/** Created by taku on 7/27/16. */
public class MedianFinderTest {
  @Test
  public void test() {
    MedianFinder mf = new MedianFinder();
    mf.addNum(1);
    mf.addNum(2);
    assertEquals(1.5, mf.findMedian(), 1e-6);
    mf.addNum(3);
    assertEquals(2, mf.findMedian(), 1e-6);
    mf.addNum(4);
    assertEquals(2.5, mf.findMedian(), 1e-6);
  }
}
