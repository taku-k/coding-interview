package leetcode;

public class RotateImage {

  public void rotate(int[][] matrix) {
    int n = matrix.length;
    for (int offset = 0; offset < Math.floor(n / 2.0); ++offset) {
      for (int col = offset; col < n - offset - 1; ++col) {
        int temp = matrix[col][n - offset - 1];
        matrix[col][n - offset - 1] = matrix[offset][col];
        matrix[offset][col] = matrix[n - offset - 1 - col][offset];
        matrix[n - offset - 1 - col][offset] = matrix[n - offset - 1][n - offset - 1 - col];
        matrix[n - offset - 1][n - offset - 1 - col] = temp;
      }
    }
  }
}
