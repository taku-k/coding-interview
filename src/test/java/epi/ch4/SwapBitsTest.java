package epi.ch4;

import org.junit.Test;

import static org.junit.Assert.*;

public class SwapBitsTest {
    @Test
    public void swap() throws Exception {
        assertEquals(SwapBits.swap(47, 1 ,4), 61);
        assertEquals(SwapBits.swap(28, 0, 2), 25);
    }
}