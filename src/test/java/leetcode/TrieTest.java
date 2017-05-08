package leetcode;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/** Created by taku on 2016/05/29. */
public class TrieTest {
  private Trie trie;

  @Before
  public void setUp() throws Exception {
    trie = new Trie();
    trie.insert("abc");
    trie.insert("aa");
  }

  @Test
  public void search() throws Exception {
    assertEquals(true, trie.search("abc"));
    assertEquals(false, trie.search("b"));
    assertEquals(false, trie.search("a"));
  }

  @Test
  public void startsWith() throws Exception {
    assertEquals(true, trie.startsWith("a"));
  }
}
