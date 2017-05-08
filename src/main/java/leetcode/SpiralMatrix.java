package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> order = new ArrayList<>();
    if (matrix.length == 0) return order;
    int m = matrix.length;
    int n = matrix[0].length;
    for (int offset = 0; offset < Math.ceil(Math.min(m, n) / 2.0); ++offset) {
      spiralOrderWithOffset(matrix, order, offset);
    }
    return order;
  }

  private void spiralOrderWithOffset(int[][] matrix, List<Integer> order, int offset) {
    int m = matrix.length;
    int n = matrix[0].length;
    for (int x = offset; x < n - offset; ++x) {
      order.add(matrix[offset][x]);
    }
    for (int y = offset + 1; y < m - offset; ++y) {
      order.add(matrix[y][n - offset - 1]);
    }
    if (offset < m - offset - 1) {
      for (int x = n - offset - 2; x >= offset; --x) {
        order.add(matrix[m - offset - 1][x]);
      }
    }
    if (offset < n - offset - 1) {
      for (int y = m - offset - 2; y >= offset + 1; --y) {
        order.add(matrix[y][offset]);
      }
    }
  }
}
