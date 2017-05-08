package epi.ch4;

import static org.junit.Assert.*;

import java.util.Random;
import org.junit.Test;

public class PowerXYTest {
  @Test
  public void power() throws Exception {
    Random r = new Random();
    for (int i = 0; i < 10000; i++) {
      double x = r.nextDouble() * 10;
      int y = r.nextInt(257) - 128;
      double expected = PowerXY.power(x, y);
      double actual = Math.pow(x, y);
      assertEquals(
          String.format("%f ^ %d = %f", x, y, Math.pow(x, y)), expected, actual, 1.0e-9 * actual);
    }
  }
}
