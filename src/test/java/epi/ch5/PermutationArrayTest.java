package epi.ch5;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class PermutationArrayTest {

  @Parameterized.Parameters(name = "Test {index}: apply({0})")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {Arrays.asList(2, 1, 0, 3), Arrays.asList(2, 1, 0, 3)},
          {Arrays.asList(3, 2, 1, 0), Arrays.asList(3, 2, 1, 0)},
          {Arrays.asList(2, 3, 1, 0), Arrays.asList(3, 2, 0, 1)}
        });
  }

  private List<Integer> perm;

  private List<Integer> expected;

  private List<Integer> A = Arrays.asList(0, 1, 2, 3);

  public PermutationArrayTest(List<Integer> perm, List<Integer> expected) {
    this.expected = expected;
    this.perm = perm;
  }

  @Test
  public void apply() throws Exception {
    PermutationArray.apply(A, perm);
    assertArrayEquals(A.toArray(), expected.toArray());
  }
}
