package epi.ch4;

import static org.junit.Assert.*;

import java.util.Random;
import org.junit.Test;

public class MultiplyShiftAddTest {
  @Test
  public void multiply() throws Exception {
    assertEquals(MultiplyShiftAdd.multiply(6, 4), 24);
  }

  @Test
  public void add() throws Exception {
    assertEquals(MultiplyShiftAdd.add(10, 20), 30);
  }

  @Test
  public void randomTest() throws Exception {
    Random r = new Random();
    for (int i = 0; i < 100000; i++) {
      int x = r.nextInt(65535), y = r.nextInt(65535);
      assertEquals(String.format("x = %d, y = %d, x + y", x, y), MultiplyShiftAdd.add(x, y), x + y);
      assertEquals(
          String.format("x = %d, y = %d, x * y", x, y),
          MultiplyShiftAdd.multiply(x, y),
          (long) x * y);
    }
  }
}
