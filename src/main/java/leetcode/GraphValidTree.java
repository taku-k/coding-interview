package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GraphValidTree {
  public boolean validTree(int n, int[][] edges) {
    List<List<Integer>> g = new ArrayList<>();

    boolean[] visited = new boolean[n];
    for (int i = 0; i < n; ++i) {
      g.add(new ArrayList<>());
    }
    for (int[] e : edges) {
      g.get(e[0]).add(e[1]);
      g.get(e[1]).add(e[0]);
    }
    if (hasCycle(0, g, visited, -1)) {
      return false;
    }

    for (int i = 0; i < n; ++i) {
      if (!visited[i]) {
        return false;
      }
    }
    return true;
  }

  private boolean hasCycle(int n, List<List<Integer>> graph, boolean[] visited, int parent) {
    if (visited[n]) return true;
    visited[n] = true;
    boolean flag = false;
    for (int to : graph.get(n)) {
      if (to != parent) {
        flag = flag || hasCycle(to, graph, visited, n);
      }
    }
    return flag;
  }
}
