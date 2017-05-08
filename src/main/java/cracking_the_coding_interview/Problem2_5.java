package cracking_the_coding_interview;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/** Created by taku on 2016/05/07. */
public class Problem2_5 {
  class Edge {
    public int to;
    public int weight;

    Edge(int to, int weight) {
      this.to = to;
      this.weight = weight;
    }
  }

  static Node addLists(Node n1, Node n2) {
    Node head = null;
    int c = 0;
    do {
      int tmp = c;
      if (n1 != null) tmp += n1.data;
      if (n2 != null) tmp += n2.data;
      c = tmp / 10;
      tmp %= 10;
      if (head == null) {
        head = new Node(tmp);
      } else {
        head.appendToTail(tmp);
      }
      if (n1 != null) n1 = n1.next;
      if (n2 != null) n2 = n2.next;
    } while (n1 != null || n2 != null);

    return head;
  }

  static void dijkstra(List<List<Edge>> g, List<Integer> d, int s) {
    // d を INF に初期化
    int INF = (int) 1e+10;
    for (int i = 0; i < d.size(); i++) {
      d.set(i, INF);
    }
    // d[s] is initialized as 0
    d.set(s, 0);
    // use priority queue
    PriorityQueue<Map.Entry<Integer, Integer>> queue =
        new PriorityQueue<>(
            new Comparator<Map.Entry<Integer, Integer>>() {
              @Override
              public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getKey() - o2.getKey();
              }
            });
    queue.add(new AbstractMap.SimpleEntry<>(0, s));

    // while que is not empty, update edge
    while (!queue.isEmpty()) {
      Map.Entry p = queue.poll();
      int v = (int) p.getValue();
      if (d.get(v) < (int) p.getKey()) continue;
      for (Edge e : g.get((int) p.getValue())) {
        if (d.get(e.to) > d.get(v) + e.weight) {
          d.set(e.to, d.get(v) + e.weight);
          queue.add(new AbstractMap.SimpleEntry<>(d.get(e.to), e.to));
        }
      }
    }
  }
}
