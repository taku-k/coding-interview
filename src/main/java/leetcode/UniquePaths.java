package leetcode;

public class UniquePaths {
  public int uniquePaths(int m, int n) {
    return helper(m - 1, n - 1, new int[m][n]);
  }

  private int helper(int x, int y, int[][] dp) {
    if (x == 0 && y == 0) {
      return 1;
    }
    if (dp[x][y] == 0) {
      int down = x == 0 ? 0 : helper(x - 1, y, dp);
      int left = y == 0 ? 0 : helper(x, y - 1, dp);
      dp[x][y] = down + left;
    }
    return dp[x][y];
  }
}
