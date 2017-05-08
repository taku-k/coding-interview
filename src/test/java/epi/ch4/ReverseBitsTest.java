package epi.ch4;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReverseBitsTest {
  @Test
  public void reverse() throws Exception {
    ReverseBits.createPrecomputedReverse();
    assertEquals(ReverseBits.reverse(0L), 0L);
    assertEquals(ReverseBits.reverse(1L), (1L << 63));
  }
}
