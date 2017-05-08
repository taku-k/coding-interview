package leetcode;

import java.util.HashSet;
import java.util.Set;

public class FriendCircles {
  class UnionFind {
    private int[] rank, parent;

    public UnionFind(int n) {
      rank = new int[n];
      parent = new int[n];
      for (int i = 0; i < n; ++i) parent[i] = i;
    }

    public int find(int x) {
      if (parent[x] == x) return x;
      else return parent[x] = find(parent[x]);
    }

    public void merge(int x, int y) {
      x = find(x);
      y = find(y);
      if (x == y) return;
      if (rank[x] < rank[y]) parent[x] = y;
      else {
        parent[y] = x;
        if (rank[x] == rank[y]) rank[x]++;
      }
    }

    public boolean same(int x, int y) {
      return find(x) == find(y);
    }
  }

  public int findCircleNum(int[][] M) {
    int n = M.length;
    UnionFind uf = new UnionFind(n);
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < i; ++j) {
        if (M[i][j] == 1) {
          uf.merge(i, j);
        }
      }
    }
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < n; ++i) {
      set.add(uf.find(i));
    }
    return set.size();
  }
}
