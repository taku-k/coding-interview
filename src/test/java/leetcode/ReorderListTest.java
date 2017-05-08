package leetcode;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ReorderListTest {

  @Parameterized.Parameters(name = "Test {index}: apply({0})")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {"", ""},
          {"1", "1"},
          {"1,2,1,2", "1,2,2,1"},
          {"1,2,3,4,5", "1,5,2,4,3"},
          {"1,2,3,4,5,6,7", "1,7,2,6,3,5,4"}
        });
  }

  private ListNode input;

  private String expected;

  private static ReorderList reorderList = new ReorderList();

  public ReorderListTest(String input, String expected) {
    this.input = Utils.lns(input);
    this.expected = expected;
  }

  @Test
  public void apply() throws Exception {
    reorderList.reorderList(input);
    assertEquals(expected, Utils.lnd(input));
  }
}
