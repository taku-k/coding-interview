package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by taku on 2016/05/25.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        /*
         * Time Complexity is O(n) where n is the length of `s`
         * Space Complexity is O(n)
         */
        int head = 0;
        int sol = 0;
        int now = 0;
        char[] chars = s.toCharArray();
        Set<Character> check = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            if (!check.contains(chars[i])) {
                now++;
                check.add(chars[i]);
                if (now > sol) sol = now;
            } else {
                now++;
                while (true) {
                    if (chars[head] == chars[i]) {
                        head++;
                        now--;
                        break;
                    }
                    check.remove(chars[head]);
                    head++;
                    now--;
                }
            }
        }
        return sol;
    }
}
