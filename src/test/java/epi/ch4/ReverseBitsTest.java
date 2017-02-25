package epi.ch4;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseBitsTest {
    @Test
    public void reverse() throws Exception {
        ReverseBits.createPrecomputedReverse();
        assertEquals(ReverseBits.reverse(0L), 0L);
        assertEquals(ReverseBits.reverse(1L), (1L << 63));
    }
}