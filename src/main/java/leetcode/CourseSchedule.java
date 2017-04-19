package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CourseSchedule {
    class StronglyConnectedComponent {
        List<List<Integer>> g;
        List<List<Integer>> rg;
        List<Integer> vs;
        List<Boolean> used;
        List<Integer> cmp;
        int maxV;

        StronglyConnectedComponent(int maxV) {
            this.maxV = maxV;
            g = new ArrayList<>(Collections.nCopies(maxV, null));
            rg = new ArrayList<>(Collections.nCopies(maxV, null));
            vs = new ArrayList<>();
            used = new ArrayList<>(Collections.nCopies(maxV, false));
            cmp = new ArrayList<>(Collections.nCopies(maxV, 0));
            for (int i = 0; i < maxV; ++i) {
                g.set(i, new ArrayList<>());
                rg.set(i, new ArrayList<>());
            }
        }

        void addEdge(int from, int to) {
            g.get(from).add(to);
            rg.get(to).add(from);
        }

        void dfs(int v) {
            used.set(v, true);
            for (int i : g.get(v)) {
                if (!used.get(i)) {
                    dfs(i);
                }
            }
            vs.add(v);
        }

        void rdfs(int v, int k) {
            used.set(v, true);
            cmp.set(v, k);
            for (int i : rg.get(v)) {
                if (!used.get(i)) {
                    rdfs(i, k);
                }
            }
        }

        int scc() {
            for (int i = 0; i < this.maxV; ++i) {
                if (!used.get(i)) {
                    dfs(i);
                }
            }
            Collections.fill(used, false);
            Collections.reverse(vs);
            int k = 0;
            for (int i : vs) {
                if (!used.get(i)) {
                    rdfs(i, k++);
                }
            }
            return k;
        }
    }

    public boolean canFinish(int numCourse, int[][] prerequisites) {
        StronglyConnectedComponent scc = new StronglyConnectedComponent(numCourse);
        for (int[] pre : prerequisites) {
            scc.addEdge(pre[1], pre[0]);
        }
        return scc.scc() == numCourse;
    }
}
