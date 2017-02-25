package epi.ch4;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParityTest {
    @Test
    public void parity() throws Exception {
        assertEquals(Parity.parity(11), 1);
        assertEquals(Parity.parity(12), 0);
    }
}