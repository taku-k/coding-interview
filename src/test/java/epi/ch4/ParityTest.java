package epi.ch4;

import static org.junit.Assert.*;

import org.junit.Test;

public class ParityTest {
  @Test
  public void parity() throws Exception {
    assertEquals(Parity.parity(11), 1);
    assertEquals(Parity.parity(12), 0);
  }
}
