package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateFile {
  public List<List<String>> findDuplicate(String[] paths) {
    Map<String, List<String>> contentToPaths = new HashMap<>();
    for (String p : paths) {
      String[] sp = p.split(" ");
      String prefix = sp[0];
      for (int i = 1; i < sp.length; ++i) {
        String content = sp[i].substring(sp[i].indexOf("(") + 1, sp[i].lastIndexOf(")"));
        String name = sp[i].substring(0, sp[i].indexOf("("));
        contentToPaths.putIfAbsent(content, new ArrayList<>());
        contentToPaths.get(content).add(prefix + "/" + name);
      }
    }
    List<List<String>> result = new ArrayList<>();
    for (List<String> p : contentToPaths.values()) {
      if (p.size() > 1) {
        result.add(p);
      }
    }
    return result;
  }
}
