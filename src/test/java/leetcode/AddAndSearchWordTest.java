package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

/** Created by taku on 7/25/16. */
public class AddAndSearchWordTest {
  @Test
  public void test() {
    AddAndSearchWord obj = new AddAndSearchWord();
    obj.addWord("bad");
    obj.addWord("dad");
    obj.addWord("mad");
    assertEquals(false, obj.search("pad"));
    assertEquals(true, obj.search("bad"));
    assertEquals(true, obj.search(".ad"));
    assertEquals(true, obj.search("b.."));
  }
}
