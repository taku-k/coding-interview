package leetcode;

public class ReshapeMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums.length == 0) return nums;
        int n = nums.length, m = nums[0].length;
        if (n * m != r * c) return nums;
        int[][] res = new int[r][c];
        int cr = 0, cc = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                res[cr][cc++] = nums[i][j];
                if (cc == c) {
                    cc = 0;
                    cr++;
                }
            }
        }
        return res;
    }
}
