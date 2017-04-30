package leetcode;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int n = s1.length();
        int[] c = new int[26];
        int[] cur = new int[26];
        for (char cc : s1.toCharArray()) {
            c[cc - 'a']++;
        }
        int i = 0;
        for (; i < n; ++i) {
            cur[s2.charAt(i) - 'a']++;
        }
        int j = 0;
        for (; i < s2.length(); ++i) {
            cur[s2.charAt(j) - 'a']--;
            cur[s2.charAt(i) - 'a']++;
            if (check(c, cur)) {
                return true;
            }
        }
        return check(c, cur);
    }

    private boolean check(int[] c, int[] cur) {
        for (int i = 0; i < 26; ++i) {
            if (c[i] != cur[i]) return false;
        }
        return true;
    }
}
