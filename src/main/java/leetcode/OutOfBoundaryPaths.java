package leetcode;

import java.util.Arrays;

public class OutOfBoundaryPaths {
    private static long[][][] dp = new long[51][51][51];
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static long MOD = 1000000007L;

    public int findPaths(int m, int n, int N, int i, int j) {
        for (int k = 0; k < 51; ++k) {
            for (int l = 0; l < 51; ++l) {
                Arrays.fill(dp[k][l], -1);
            }
        }
        return (int)dfs(m, n, N, j, i);
    }

    private long dfs(int m, int n, int N, int x, int y) {
        if (N < 0) return 0;
        if (dp[N][x][y] != -1) return dp[N][x][y];
        long result = 0;
        for (int c = 0; c < 4; ++c) {
            int nx = x + dx[c];
            int ny = y + dy[c];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                result = (result + dfs(m, n, N - 1, nx, ny)) % MOD;
            } else if (N != 0) {
                result = (result + 1) % MOD;
            }
        }
        dp[N][x][y] = result;
        return result;
    }
}
