package leetcode;

import java.util.*;

public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<UndirectedGraphNode, UndirectedGraphNode> graphs = new HashMap<>();
        graphs.put(node, new UndirectedGraphNode(node.label));
        Deque<UndirectedGraphNode> que = new LinkedList<>();
        que.add(node);
        while (!que.isEmpty()) {
            UndirectedGraphNode cur = que.pollFirst();
            for (UndirectedGraphNode next : cur.neighbors) {
                if (!graphs.containsKey(next)) {
                    graphs.put(next, new UndirectedGraphNode(next.label));
                    que.add(next);
                }
                graphs.get(cur).neighbors.add(graphs.get(next));
            }
        }
        return graphs.get(node);
    }
}
