package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<Integer>> simplifiedResult = new ArrayList<>();
        helper(n, 0, new ArrayList<>(), simplifiedResult);
        List<List<String>> result = new ArrayList<>();
        for (List<Integer> board : simplifiedResult) {
            List<String> temp = new ArrayList<>();
            for (Integer col : board) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; ++i) {
                    if (i == col) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                temp.add(sb.toString());
            }
            result.add(temp);
        }
        return result;
    }

    private void helper(int n, int row, List<Integer> colPlacement, List<List<Integer>> result) {
        if (row == n) {
            result.add(new ArrayList<>(colPlacement));
            return;
        }
        for (int col = 0; col < n; ++col) {
            colPlacement.add(col);
            if (isValid(colPlacement)) {
                helper(n, row + 1, colPlacement, result);
            }
            colPlacement.remove(colPlacement.size() - 1);
        }
    }

    private boolean isValid(List<Integer> colPlacement) {
        int rowID = colPlacement.size() - 1;
        for (int i = 0; i < rowID; ++i) {
            int diff = Math.abs(colPlacement.get(rowID) - colPlacement.get(i));
            if (diff == 0 || diff == rowID - i) {
                return false;
            }
        }
        return true;
    }

}
