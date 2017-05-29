package epi.ch12;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubseqCover {
  public static Subarray findSmallestSequentiallyCoveringSubset(
      List<String> paragraph, List<String> keywords) {
    Map<String, Integer> keyToIdx = new HashMap<>();
    Map<String, Integer> lastOccur = new HashMap<>();
    Map<String, Integer> shortLen = new HashMap<>();
    for (int i = 0; i < keywords.size(); ++i) {
      keyToIdx.put(keywords.get(i), i);
      lastOccur.put(keywords.get(i), -1);
      shortLen.put(keywords.get(i), Integer.MAX_VALUE);
    }
    int min = Integer.MAX_VALUE;
    Subarray result = new Subarray(-1, -1);
    for (int i = 0; i < paragraph.size(); ++i) {
      String s = paragraph.get(i);
      Integer idx = keyToIdx.get(s);
      if (idx == null) continue;
      if (keywords.contains(s)) {
        if (idx == 0) {
          shortLen.put(s, 1);
        } else if (shortLen.get(keywords.get(idx - 1)) != Integer.MAX_VALUE) {
          shortLen.put(
              keywords.get(idx),
              i - lastOccur.get(keywords.get(idx - 1)) + shortLen.get(keywords.get(idx - 1)));
        }
        lastOccur.put(s, i);
      }
      if (idx == keywords.size() - 1) {
        if (min > shortLen.get(s)) {
          min = shortLen.get(s);
          result.end = i;
          result.start = i - shortLen.get(s) + 1;
        }
      }
    }
    return result;
  }
}
