package epi.ch12;

import static epi.ch12.AverageTop3Scores.findStudentWithHighestBestOfThreeScores;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.junit.Test;

public class AverageTop3ScoresTest {

  @Test
  public void simpleTest() {
    List<Object> nameScoreData = new ArrayList<>();
    nameScoreData.add("adnan");
    nameScoreData.add(100);
    nameScoreData.add("amit");
    nameScoreData.add(99);
    nameScoreData.add("adnan");
    nameScoreData.add(98);
    nameScoreData.add("thl");
    nameScoreData.add(90);
    nameScoreData.add("adnan");
    nameScoreData.add(10);
    nameScoreData.add("amit");
    nameScoreData.add(100);
    nameScoreData.add("thl");
    nameScoreData.add(99);
    nameScoreData.add("thl");
    nameScoreData.add(95);
    nameScoreData.add("dd");
    nameScoreData.add(100);
    nameScoreData.add("dd");
    nameScoreData.add(100);
    nameScoreData.add("adnan");
    nameScoreData.add(99);
    String result = findStudentWithHighestBestOfThreeScores(nameScoreData.iterator());
    assertEquals("adnan", result);
  }

  @Test
  public void test() {
    Random r = new Random();
    int n = r.nextInt(10000) + 1;
    List<Object> nameScoreData = new ArrayList<>();
    for (int i = 0; i < n; ++i) {
      int testNum = r.nextInt(21);
      String name = randString(r.nextInt(6) + 5);
      while (testNum-- > 0) {
        nameScoreData.add(name);
        nameScoreData.add(r.nextInt(101));
      }
    }
    String name = findStudentWithHighestBestOfThreeScores(nameScoreData.iterator());
    assertEquals(checkAns(nameScoreData.iterator()), name);
  }

  private static String checkAns(Iterator<Object> iter) {
    Map<String, List<Integer>> s2l = new HashMap<>();
    while (iter.hasNext()) {
      String n = (String) iter.next();
      Integer s = (Integer) iter.next();
      s2l.putIfAbsent(n, new ArrayList<>());
      s2l.get(n).add(s);
    }
    String result = "";
    int max = Integer.MIN_VALUE;
    for (Map.Entry<String, List<Integer>> e : s2l.entrySet()) {
      String n = e.getKey();
      List<Integer> l = e.getValue();
      Collections.sort(l, Collections.reverseOrder());
      if (l.size() < 3) continue;
      int sum = l.get(0) + l.get(1) + l.get(2);
      if (sum > max) {
        max = sum;
        result = n;
      }
    }
    return result;
  }

  private static String randString(int len) {
    Random r = new Random();
    StringBuilder ret = new StringBuilder(len);
    while (len-- > 0) {
      ret.append((char) (r.nextInt(26) + 'A'));
    }
    return ret.toString();
  }
}
