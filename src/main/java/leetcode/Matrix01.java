package leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Matrix01 {
    private class Coordinate {
        int x, y;
        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix.length == 0) return null;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dist = new int[n][m];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        Deque<Coordinate> que = new LinkedList<>();
        for (int y = 0; y < n; ++y) {
            for (int x = 0; x < m; ++x) {
                if (matrix[y][x] == 0) {
                    dist[y][x] = 0;
                    que.addLast(new Coordinate(x, y));
                }
            }
        }
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!que.isEmpty()) {
            Coordinate coord = que.pollFirst();
            int x = coord.x, y = coord.y;
            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && dist[ny][nx] > dist[y][x] + 1) {
                    dist[ny][nx] = dist[y][x] + 1;
                    que.addLast(new Coordinate(nx, ny));
                }
            }
        }
        return dist;
    }
}
