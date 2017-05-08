package leetcode;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Iterator;
import org.junit.Test;

/** Created by taku on 7/27/16. */
public class PeekingIteratorTest {
  @Test
  public void test() {
    Iterator<Integer> iter = Arrays.asList(new Integer[] {1, 2, 3}).iterator();
    PeekingIterator piter = new PeekingIterator(iter);
    assertEquals(1, piter.next().intValue());
    assertEquals(2, piter.peek().intValue());
    assertEquals(2, piter.next().intValue());
    assertEquals(3, piter.next().intValue());
    assertEquals(false, piter.hasNext());
  }
}
