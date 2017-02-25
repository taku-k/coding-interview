package epi.ch4;

public class PalindromeNumber {
    public static boolean check(int x) {
        if (x < 0) {
            return false;
        }
        int len = (int)Math.floor(Math.log10(x)) + 1;
        int mask = (int)Math.pow(10, len -1);
        for (int i = 0; i < len / 2; i++) {
            if (x / mask != x % 10) {
                return false;
            }
            x %= mask;
            x /= 10;
            mask /= 100;
        }
        return true;
    }
}
