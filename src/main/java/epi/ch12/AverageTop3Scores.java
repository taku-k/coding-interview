package epi.ch12;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

public class AverageTop3Scores {
  public static String findStudentWithHighestBestOfThreeScores(Iterator<Object> nameScoreData) {
    Map<String, PriorityQueue<Integer>> studentToPQ = new HashMap<>();
    while (nameScoreData.hasNext()) {
      String name = (String) nameScoreData.next();
      Integer score = (Integer) nameScoreData.next();
      studentToPQ.putIfAbsent(name, new PriorityQueue<>());
      PriorityQueue<Integer> que = studentToPQ.get(name);
      que.add(score);
      if (que.size() > 3) {
        que.poll();
      }
    }
    String result = "";
    int max = Integer.MIN_VALUE;
    for (Map.Entry<String, PriorityQueue<Integer>> e : studentToPQ.entrySet()) {
      PriorityQueue<Integer> que = e.getValue();
      if (que.size() < 3) {
        continue;
      }
      int sum = 0;
      while (!que.isEmpty()) sum += que.poll();
      if (sum > max) {
        max = sum;
        result = e.getKey();
      }
    }
    return result;
  }
}
