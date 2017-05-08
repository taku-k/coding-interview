package leetcode;

public class LongestLineConsecutiveOneMatrix {
  public int longestLine(int[][] M) {
    if (M.length == 0) return 0;
    int n = M.length;
    int m = M[0].length;
    int ans = 0;
    for (int i = 0; i < n; ++i) {
      int cnt = 0;
      for (int j = 0; j < m; ++j) {
        if (M[i][j] == 1) {
          cnt += 1;
        } else {
          ans = Math.max(ans, cnt);
          cnt = 0;
        }
      }
      ans = Math.max(ans, cnt);
    }
    for (int j = 0; j < m; ++j) {
      int cnt = 0;
      for (int i = 0; i < n; ++i) {
        if (M[i][j] == 1) {
          cnt += 1;
        } else {
          ans = Math.max(ans, cnt);
          cnt = 0;
        }
      }
      ans = Math.max(ans, cnt);
    }
    for (int ys = 0; ys < n; ++ys) {
      int x = 0;
      int y = ys;
      int cnt = 0;
      while (isFeasible(M, x, y)) {
        if (M[y][x] == 1) {
          cnt += 1;
        } else {
          ans = Math.max(ans, cnt);
          cnt = 0;
        }
        x += 1;
        y += 1;
      }
      ans = Math.max(ans, cnt);
    }
    for (int xs = 0; xs < m; ++xs) {
      int x = xs;
      int y = 0;
      int cnt = 0;
      while (isFeasible(M, x, y)) {
        if (M[y][x] == 1) {
          cnt += 1;
        } else {
          ans = Math.max(ans, cnt);
          cnt = 0;
        }
        x += 1;
        y += 1;
      }
      ans = Math.max(ans, cnt);
    }
    for (int ys = 0; ys < n; ++ys) {
      int x = M[0].length - 1;
      int y = ys;
      int cnt = 0;
      while (isFeasible(M, x, y)) {
        if (M[y][x] == 1) {
          cnt += 1;
        } else {
          ans = Math.max(ans, cnt);
          cnt = 0;
        }
        x -= 1;
        y -= 1;
      }
      ans = Math.max(ans, cnt);
    }
    for (int xs = 0; xs < m; ++xs) {
      int x = xs;
      int y = 0;
      int cnt = 0;
      while (isFeasible(M, x, y)) {
        if (M[y][x] == 1) {
          cnt += 1;
        } else {
          ans = Math.max(ans, cnt);
          cnt = 0;
        }
        x -= 1;
        y -= 1;
      }
      ans = Math.max(ans, cnt);
    }
    return ans;
  }

  private boolean isFeasible(int[][] M, int x, int y) {
    return x >= 0 && x < M[0].length && y >= 0 && y < M.length;
  }
}
