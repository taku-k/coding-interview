package leetcode;

import java.util.*;

public class RepeatedDNASequences {
  public List<String> findRepeatedDnaSequences(String s) {
    Set<String> occurences = new HashSet<>();
    Set<String> result = new HashSet<>();
    for (int i = 0; i <= s.length() - 10; ++i) {
      String ten = s.substring(i, i + 10);
      if (occurences.contains(ten)) {
        result.add(ten);
      }
      occurences.add(ten);
    }
    List<String> res = new ArrayList<>(result);
    return res;
  }
}
