package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class LongestUncommonSubsequence2 {
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, Collections.reverseOrder(Comparator.comparingInt(String::length)));
        for (String w1 : strs) {
            boolean flag = true;
            for (String w2 : strs) {
                if (w1 == w2) continue;
                int i = 0;
                for (int j = 0; j < w2.length(); ++j) {
                    if (i < w1.length() && w1.charAt(i) == w2.charAt(j)) {
                        ++i;
                    }
                }
                if (i == w1.length()) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return w1.length();
            }
        }
        return -1;
    }
}
