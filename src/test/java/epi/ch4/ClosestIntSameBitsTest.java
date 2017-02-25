package epi.ch4;

import org.junit.Test;

import static org.junit.Assert.*;

public class ClosestIntSameBitsTest {
    @Test
    public void find() throws Exception {
        assertEquals(ClosestIntSameBits.find(1), 2);
        assertEquals(ClosestIntSameBits.find(6), 5);
        assertEquals(ClosestIntSameBits.find(7), 11);
        assertEquals(ClosestIntSameBits.find(32), 16);
        assertEquals(ClosestIntSameBits.find(Long.MAX_VALUE - 1), Long.MAX_VALUE - 2);
    }
}