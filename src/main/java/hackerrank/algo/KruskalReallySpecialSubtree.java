package hackerrank.algo;

import java.io.*;
import java.util.*;
import java.lang.*;

public class KruskalReallySpecialSubtree {
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

        private static boolean isPrintableChar(int c) {
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

    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int cost;
        Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            if (cost != o.cost) {
                return Integer.compare(cost, o.cost);
            }
            return Integer.compare(from + to + cost, o.from + o.to + o.cost);
        }
    }

    static class UnionFind {
        private int[] rank, parent;

        public UnionFind(int n) {
            rank = new int[n];
            parent = new int[n];
            for (int i = 0; i < n; ++i) parent[i] = i;
        }

        public int find(int x) {
            if (parent[x] == x) return x;
            else return parent[x] =  find(parent[x]);
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

    static int kruskal(List<Edge> edges, int n) {
        Collections.sort(edges);
        UnionFind uf = new UnionFind(n);
        int res = 0;
        for (int i = 0; i < edges.size(); ++i) {
            Edge e = edges.get(i);
            if (!uf.same(e.to, e.from)) {
                uf.merge(e.to, e.from);
                res += e.cost;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int m = fs.nextInt();
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            int x = fs.nextInt() - 1;
            int y = fs.nextInt() - 1;
            int r = fs.nextInt();
            edges.add(new Edge(x, y, r));
        }
        System.out.println(kruskal(edges, n));
    }
}
