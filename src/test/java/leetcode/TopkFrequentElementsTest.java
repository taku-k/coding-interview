package leetcode;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/** Created by taku on 7/12/16. */
@RunWith(Parameterized.class)
public class TopkFrequentElementsTest {
  private static TopkFrequentElements obj = new TopkFrequentElements();

  @Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {Arrays.asList(1, 1, 1, 2, 2, 3), 2, Arrays.asList(1, 2)},
          {Arrays.asList(1), 1, Arrays.asList(1)},
          {Arrays.asList(4, 1, -1, 2, -1, 2, 3), 2, Arrays.asList(-1, 2)}
        });
  }

  @Parameter // first data value (0) is default
  public List<Integer> nums;

  @Parameter(value = 1)
  public int k;

  @Parameter(value = 2)
  public List<Integer> expected;

  @Test
  public void test() {
    assertArrayEquals(expected.toArray(), obj.topKFrequent(nums, k).toArray());
  }
}
