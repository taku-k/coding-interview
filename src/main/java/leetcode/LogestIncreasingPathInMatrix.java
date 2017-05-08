package leetcode;

public class LogestIncreasingPathInMatrix {
  private static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

  public int longestIncreasingPath(int[][] matrix) {
    if (matrix.length == 0) return 0;
    int n = matrix.length, m = matrix[0].length;
    int[][] dp = new int[n][m];
    int res = 0;
    for (int y = 0; y < n; ++y) {
      for (int x = 0; x < m; ++x) {
        res = Math.max(res, dfs(matrix, dp, n, m, x, y));
      }
    }
    return res;
  }

  private int dfs(int[][] matrix, int[][] dp, int n, int m, int x, int y) {
    if (dp[y][x] != 0) return dp[y][x];
    int max = 1;
    for (int[] dir : dirs) {
      int nx = x + dir[0], ny = y + dir[1];
      if (nx >= 0 && nx < m && ny >= 0 && ny < n && matrix[y][x] < matrix[ny][nx]) {
        max = Math.max(max, dfs(matrix, dp, n, m, nx, ny) + 1);
      }
    }
    dp[y][x] = max;
    return max;
  }
}
