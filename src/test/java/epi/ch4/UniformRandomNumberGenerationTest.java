package epi.ch4;

import static org.assertj.core.api.Assertions.*;

import java.util.Random;
import org.junit.Test;

public class UniformRandomNumberGenerationTest {
  @Test
  public void rand() throws Exception {
    Random r = new Random();
    for (int i = 0; i < 10000; i++) {
      int a = r.nextInt(100);
      int b = r.nextInt(100) + a + 1;
      int expected = UniformRandomNumberGeneration.rand(a, b);
      assertThat(expected).isGreaterThanOrEqualTo(a).isLessThanOrEqualTo(b);
    }
  }
}
