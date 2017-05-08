package leetcode;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/** Created by taku on 2016/05/25. */
public class LongestSubstringWithoutRepeatingCharactersTest {
  LongestSubstringWithoutRepeatingCharacters ins;

  @Before
  public void setUp() throws Exception {
    this.ins = new LongestSubstringWithoutRepeatingCharacters();
  }

  @Test
  public void lengthOfLongestSubstring() throws Exception {
    assertEquals(3, ins.lengthOfLongestSubstring("abcabcbb"));
    assertEquals(1, ins.lengthOfLongestSubstring("aaaaa"));
    assertEquals(3, ins.lengthOfLongestSubstring("pwwkew"));
    assertEquals(0, ins.lengthOfLongestSubstring(""));
    assertEquals(1, ins.lengthOfLongestSubstring("a"));
  }
}
