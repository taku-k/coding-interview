package leetcode;

import java.util.*;

public class GrayCode {
    private List<Integer> result;
    public List<Integer> grayCode(int n) {
        directedGrayCode(n, 0, new HashSet<>(Arrays.asList(0)), new ArrayList<>(Arrays.asList(0)));
        return result;
    }

    private void directedGrayCode(int n, int i, Set<Integer> used, List<Integer> codes) {
        if (codes.size() == (1 << n) && differSuccessive(codes.get(0), codes.get(codes.size() - 1))) {
            result = new ArrayList<>(codes);
            return;
        }
        for (int j = 0; j < n; ++j) {
            int changed = i ^ (1 << j);
            if (!used.contains(changed)) {
                used.add(changed);
                codes.add(changed);
                directedGrayCode(n, changed, used, codes);
                used.remove(changed);
                codes.remove(codes.size() - 1);
            }
        }
    }

    private boolean differSuccessive(int i, int j) {
        return (i ^ j) != 0 && ((i ^ j) & ((i ^ j) - 1)) == 0;
    }
}
