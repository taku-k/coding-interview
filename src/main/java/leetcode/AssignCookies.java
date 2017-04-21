package leetcode;

import java.util.Arrays;

public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        int ans = 0, cookie = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        for (int i = 0; i < g.length; ++i) {
            while (cookie < s.length) {
                if (g[i] <= s[cookie]) {
                    ans++;
                    cookie++;
                    break;
                } else {
                    cookie++;
                }
            }
        }
        return ans;
    }
}
