package leetcode;

import java.util.*;

public class MinimumHeightTrees {
    private class Vertex {
        int label;
        Set<Vertex> edges;
        Vertex(int label) {
            this.label = label;
            this.edges = new HashSet<>();
        }
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Vertex> g = new ArrayList<>();
        if (n == 1) return Arrays.asList(0);
        for (int i = 0; i < n; ++i) {
            g.add(new Vertex(i));
        }
        for (int[] e : edges) {
            g.get(e[0]).edges.add(g.get(e[1]));
            g.get(e[1]).edges.add(g.get(e[0]));
        }
        Deque<Vertex> que = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (g.get(i).edges.size() == 1) {
                que.addLast(g.get(i));
            }
        }
        while (n > 2) {
            n -= que.size();
            Deque<Vertex> next = new LinkedList<>();
            while (!que.isEmpty()) {
                Vertex cur = que.pollFirst();
                for (Vertex v : cur.edges) {
                    v.edges.remove(cur);
                    if (v.edges.size() == 1) {
                        next.add(v);
                    }
                }
            }
            que = next;
        }
        while (!que.isEmpty()) res.add(que.pollFirst().label);
        return res;
    }
}
