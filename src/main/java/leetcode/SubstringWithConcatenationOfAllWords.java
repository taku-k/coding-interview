package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
  public List<Integer> findSubstring(String s, String[] words) {
    List<Integer> result = new ArrayList<>();
    if (words.length == 0) return result;
    Map<String, Integer> cover = new HashMap<>();
    for (String w : words) {
      cover.put(w, cover.getOrDefault(w, 0) + 1);
    }
    int lenw = words[0].length();
    for (int i = 0; i <= s.length() - words.length * lenw; ++i) {
      Map<String, Integer> candidates = new HashMap<>();
      candidates.putAll(cover);
      boolean flag = true;
      for (int j = 0; j < words.length; ++j) {
        int start = i + j * lenw;
        int end = start + lenw + 1;
        String sub = s.substring(start, end);
        if (!candidates.containsKey(sub)) {
          flag = false;
          break;
        }
        if (candidates.get(sub) == 0) {
          flag = false;
          break;
        }
        candidates.put(sub, candidates.get(sub) - 1);
      }
      if (flag) {
        result.add(i);
      }
    }
    return result;
  }
}
