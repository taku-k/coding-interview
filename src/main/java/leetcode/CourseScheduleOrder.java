package leetcode;

import java.util.*;

public class CourseScheduleOrder {
    class TopologicalSort {
        List<Integer>[] g;
        int V;

        TopologicalSort(int v) {
            V = v;
            g = new ArrayList[v];
            for (int i = 0; i < v; ++i) {
                g[i] = new ArrayList<>();
            }
        }

        void addEdge(int from, int to) {
            g[from].add(to);
        }

        int[] topologicalSort() {
            Deque<Integer> que = new LinkedList<>();
            int[] sorted = new int[V];
            int[] inCounts = new int[V];
            for (int from = 0; from < V; ++from) {
                for (int to : g[from]) {
                    inCounts[to]++;
                }
            }
            for (int i = 0; i < V; ++i) {
                if (inCounts[i] == 0) {
                    que.offer(i);
                }
            }
            int visited = 0;
            while (!que.isEmpty()) {
                int cur = que.poll();
                sorted[visited++] = cur;
                for (int i = 0; i < g[cur].size(); ++i) {
                    int next = g[cur].get(i);
                    inCounts[next]--;
                    if (inCounts[next] == 0) {
                        que.offer(next);
                    }
                }
            }
            return V == visited ? sorted : new int[0];
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        TopologicalSort topo = new TopologicalSort(numCourses);
        for (int[] pre : prerequisites) {
            topo.addEdge(pre[1], pre[0]);
        }
        return topo.topologicalSort();
    }
}
