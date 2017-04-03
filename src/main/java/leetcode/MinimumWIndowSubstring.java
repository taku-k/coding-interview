package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumWIndowSubstring {
    public String minWindow(String s, String t) {
        if (s.isEmpty() || t.isEmpty()) {
            return "";
        }
        Map<Character, Integer> keywordsToCover = new HashMap<>();
        for (int i = 0; i < t.length(); ++i) {
            keywordsToCover.put(t.charAt(i), keywordsToCover.getOrDefault(t.charAt(i), 0) + 1);
        }
        String result = "";
        int remaining = t.length();
        for (int left = 0, right = 0; right < s.length(); ++right) {
            Integer count = keywordsToCover.get(s.charAt(right));
            if (count != null) {
                keywordsToCover.put(s.charAt(right), --count);
                if (count >= 0) {
                    --remaining;
                }
            }
            while (remaining == 0) {
                if (result.isEmpty() || right - left < result.length()) {
                    result = s.substring(left, right + 1);
                }
                count = keywordsToCover.get(s.charAt(left));
                if (count != null) {
                    keywordsToCover.put(s.charAt(left), ++count);
                    if (count > 0) {
                        ++remaining;
                    }
                }
                ++left;
            }
        }
        return result;
    }
}
