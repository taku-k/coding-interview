package leetcode;

import java.util.ArrayList;
import java.util.List;

public class CompressedStringIterator {
  private List<Character> chars;
  private List<Integer> counts;
  private int nowIdx;

  public CompressedStringIterator(String compressedString) {
    chars = new ArrayList<>();
    counts = new ArrayList<>();
    for (int i = 0; i < compressedString.length(); ) {
      char c = compressedString.charAt(i++);
      int s = i;
      while (i < compressedString.length() && Character.isDigit(compressedString.charAt(i))) {
        ++i;
      }
      int cnt = Integer.parseInt(compressedString.substring(s, i));
      chars.add(c);
      counts.add(cnt);
    }
    nowIdx = 0;
  }

  public char next() {
    if (nowIdx == chars.size()) {
      return ' ';
    } else {
      char ret = chars.get(nowIdx);
      counts.set(nowIdx, counts.get(nowIdx) - 1);
      if (counts.get(nowIdx) == 0) {
        ++nowIdx;
      }
      return ret;
    }
  }

  public boolean hasNext() {
    return nowIdx != chars.size();
  }
}
