package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
  public List<List<String>> partition(String s) {
    List<List<String>> result = new ArrayList<>();
    directedPartition(0, s, new ArrayList<>(), result);
    return result;
  }

  private void directedPartition(
      int offset, String s, List<String> partitioned, List<List<String>> result) {
    if (offset == s.length()) {
      result.add(new ArrayList<>(partitioned));
      return;
    }
    for (int i = offset + 1; i <= s.length(); ++i) {
      String temp = s.substring(offset, i);
      partitioned.add(temp);
      if (isPalindrome(temp)) {
        directedPartition(i, s, partitioned, result);
      }
      partitioned.remove(partitioned.size() - 1);
    }
  }

  private boolean isPalindrome(String s) {
    for (int i = 0, j = s.length() - 1; i < j; ++i, --j) {
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
    }
    return true;
  }
}
