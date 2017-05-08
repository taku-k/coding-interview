package hackerrank.algo;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import org.junit.Test;

public class LexicographicallySmallestSubstringBuilderTest {
  @Test
  public void testBuild() throws Exception {
    test(LexicographicallySmallestSubstringBuilder::build);
  }

  @Test
  public void testBuild2() throws Exception {
    test(LexicographicallySmallestSubstringBuilder::build2);
  }

  public void test(Function<List<String>, String> targetFunc) throws Exception {
    assertEquals("abcd", targetFunc.apply(Arrays.asList("ac", "bd")));
    assertEquals("aaab", targetFunc.apply(Arrays.asList("aa", "ab")));
  }
}
