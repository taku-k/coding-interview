package leetcode;

public class SpiralMatrix2 {
    public int[][] generateMatrix(int n) {
        int[][] m = new int[n][n];
        int cnt = 1;
        for (int offset = 0; offset < Math.ceil(n / 2.0); ++offset) {
            cnt = spiralMatrix(m, n, offset, cnt);
        }
        return m;
    }

    private int spiralMatrix(int[][] m, int n, int offset, int cnt) {
        for (int x = offset; offset < n - offset; ++x) {
            m[offset][x] = cnt++;
        }
        for (int y = offset + 1; y < n - offset; ++y) {
            m[y][n - offset - 1] = cnt++;
        }
        for (int x = n - offset - 2; x >= offset; --x) {
            m[n - offset - 1][x] = cnt++;
        }
        for (int y = n - offset - 2; y >= offset + 1; --y) {
            m[y][offset] = cnt++;
        }
        return cnt;
    }
}
