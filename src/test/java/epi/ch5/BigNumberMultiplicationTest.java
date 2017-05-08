package epi.ch5;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;
import org.junit.Test;
import utils.Utils;

public class BigNumberMultiplicationTest {
  @Test
  public void apply() throws Exception {
    Random r = new Random();
    for (int t = 0; t < 10000; ++t) {
      int a = r.nextInt(10000) - 5000;
      int b = r.nextInt(10000) - 5000;
      List<Integer> list1 = Utils.intToList(a);
      List<Integer> list2 = Utils.intToList(b);
      assertEquals(a, (int) Utils.listToInt(list1));
      assertEquals(b, (int) Utils.listToInt(list2));
      List<Integer> expected = Utils.intToList(a * b);
      List<Integer> actual = BigNumberMultiplication.multiply(list1, list2);
      assertArrayEquals(
          String.format("%d * %d = %d", a, b, Utils.listToInt(actual)),
          expected.toArray(),
          actual.toArray());
    }
  }
}
