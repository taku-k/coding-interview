package leetcode;

import java.util.ArrayList;
import java.util.List;

public class NumberConnectedComponentsUndirectedGraph {
  private class Node {
    int n;
    List<Integer> nodes;

    Node(int n) {
      this.n = n;
      this.nodes = new ArrayList<>();
    }
  }

  public int countComponents(int n, int[][] edges) {
    boolean[] visited = new boolean[n];
    int ans = 0;
    List<Node> nodes = new ArrayList<>();
    for (int i = 0; i < n; ++i) {
      nodes.add(new Node(i));
    }
    for (int[] e : edges) {
      nodes.get(e[0]).nodes.add(e[1]);
      nodes.get(e[1]).nodes.add(e[0]);
    }
    for (int i = 0; i < n; ++i) {
      if (!visited[i]) {
        ++ans;
        dfs(i, nodes, visited);
      }
    }
    return ans;
  }

  private void dfs(int n, List<Node> nodes, boolean[] visited) {
    if (visited[n]) return;
    visited[n] = true;
    for (Integer node : nodes.get(n).nodes) {
      dfs(node, nodes, visited);
    }
  }
}
