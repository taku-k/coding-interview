package leetcode;

public class IsSubsequence {
  public boolean isSubsequence(String s, String t) {
    if (s.length() == 0) return true;
    int si = 0;
    for (int i = 0; i < t.length(); ++i) {
      if (s.charAt(si) == t.charAt(i)) {
        si++;
      }
      if (si == s.length()) break;
    }
    return si == s.length();
  }
}
