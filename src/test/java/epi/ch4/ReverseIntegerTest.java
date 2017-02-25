package epi.ch4;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseIntegerTest {
    @Test
    public void reverse() throws Exception {
        assertEquals(ReverseInteger.reverse(321), 123);
        assertEquals(ReverseInteger.reverse(-1000123), -3210001);
    }
}