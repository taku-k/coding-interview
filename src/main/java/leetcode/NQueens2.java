package leetcode;

import java.util.ArrayList;
import java.util.List;

public class NQueens2 {
  public int totalNQueens(int n) {
    return rec(0, n, new ArrayList<>());
  }

  private int rec(int row, int n, List<Integer> board) {
    if (board.size() == n) {
      return 1;
    }
    int res = 0;
    for (int i = 0; i < n; ++i) {
      board.add(i);
      if (isValid(board)) {
        res += rec(row + 1, n, board);
      }
      board.remove(board.size() - 1);
    }
    return res;
  }

  private boolean isValid(List<Integer> board) {
    int rowId = board.size() - 1;
    for (int i = 0; i < rowId; ++i) {
      int diff = Math.abs(board.get(i) - board.get(rowId));
      if (diff == 0 || diff == rowId - i) {
        return false;
      }
    }
    return true;
  }
}
