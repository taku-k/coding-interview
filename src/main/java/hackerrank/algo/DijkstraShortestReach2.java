package hackerrank.algo;

import java.io.*;
import java.util.*;

public class DijkstraShortestReach2 {
    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1024];
        private int ptr = 0;
        private int buflen = 0;

        private boolean hasNextByte() {
            if (ptr < buflen) {
                return true;
            } else {
                ptr = 0;
                try {
                    buflen = in.read(buffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (buflen <= 0) {
                    return false;
                }
            }
            return true;
        }

        private int readByte() {
            if (hasNextByte()) return buffer[ptr++];
            else return -1;
        }

        private boolean isPrintableChar(int c) {
            return 33 <= c && c <= 126;
        }

        public boolean hasNext() {
            while (hasNextByte() && !isPrintableChar(buffer[ptr])) ptr++;
            return hasNextByte();
        }

        public String next() {
            if (!hasNext()) throw new NoSuchElementException();
            StringBuilder sb = new StringBuilder();
            int b = readByte();
            while (isPrintableChar(b)) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        public long nextLong() {
            if (!hasNext()) throw new NoSuchElementException();
            long n = 0;
            boolean minus = false;
            int b = readByte();
            if (b == '-') {
                minus = true;
                b = readByte();
            }
            if (b < '0' || '9' < b) {
                throw new NumberFormatException();
            }
            while (true) {
                if ('0' <= b && b <= '9') {
                    n *= 10;
                    n += b - '0';
                } else if (b == -1 || !isPrintableChar(b)) {
                    return minus ? -n : n;
                } else {
                    throw new NumberFormatException();
                }
                b = readByte();
            }
        }

        public int nextInt() {
            long nl = nextLong();
            if (nl < Integer.MIN_VALUE || nl > Integer.MAX_VALUE) throw new NumberFormatException();
            return (int) nl;
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    static class Edge {
        int to;
        int cost;
        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static class Pair implements Comparable<Pair> {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(first, o.first);
        }
    }

    static int[] dijkstra(List<List<Edge>> g, int s) {
        /*
         * g: the adjacent list
         *  e.g. ([[Edge(1, 10)], [Edge(0, 10), Edge(2, 3)], [Edge(1, 3)]]
         *    [1]
         * 10 / \ 3
         *  [0] [2]
         * s: starting vertex
         * ret: distances to each vertex from starting point.
         * A distance of a vertex which it's not reachable from starting point is Integer.MAX_VALUE
         */
        int n = g.size();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;
        PriorityQueue<Pair> que = new PriorityQueue<>();
        que.add(new Pair(0, s));

        while (!que.isEmpty()) {
            Pair p = que.poll();
            int v = p.second;
            if (dist[v] < p.first) continue;
            for (Edge e : g.get(v)) {
                if (dist[e.to] > dist[v] + e.cost) {
                    dist[e.to] = dist[v] + e.cost;
                    que.add(new Pair(dist[e.to], e.to));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();
            List<List<Edge>> graph = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < m; ++i) {
                int x = fs.nextInt() - 1;
                int y = fs.nextInt() - 1;
                int r = fs.nextInt();
                graph.get(x).add(new Edge(y, r));
                graph.get(y).add(new Edge(x, r));
            }
            int s = fs.nextInt() - 1;
            int[] dist = dijkstra(graph, s);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; ++i) {
                if (i != s) {
                    if (dist[i] != Integer.MAX_VALUE) {
                        sb.append(dist[i]);
                    } else {
                        sb.append(-1);
                    }
                    if (i < n - 1) {
                        sb.append(' ');
                    }
                }
            }
            System.out.println(sb.toString());
        }
    }
}
