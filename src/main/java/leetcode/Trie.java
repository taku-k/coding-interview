package leetcode;

/** Created by taku on 2016/05/28. */
public class Trie {
  private TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  // Inserts a word into the trie.
  public void insert(String word) {
    TrieNode now = root;
    int len = word.length();
    for (int i = 0; i < len; i++) {
      char c = word.charAt(i);
      if (now.labels.containsKey(c)) {
        now = now.labels.get(c);
      } else {
        TrieNode ntn = new TrieNode();
        now.labels.put(c, ntn);
        now = ntn;
      }
    }
    now.termination = true;
  }

  // Returns if the word is in the trie.
  public boolean search(String word) {
    TrieNode now = root;
    int len = word.length();
    for (int i = 0; i < len; i++) {
      char c = word.charAt(i);
      if (!now.labels.containsKey(c)) {
        return false;
      }
      now = now.labels.get(c);
    }
    if (now.termination) {
      return true;
    }
    return false;
  }

  // Returns if there is any word in the trie
  // that starts with the given prefix.
  public boolean startsWith(String prefix) {
    TrieNode now = root;
    int len = prefix.length();
    for (int i = 0; i < len; i++) {
      char c = prefix.charAt(i);
      if (!now.labels.containsKey(c)) {
        return false;
      }
      now = now.labels.get(c);
    }
    return true;
  }
}
