package epi.ch4;

public class ReverseInteger {
    public static long reverse(int x) {
        int res = 0, remaining = Math.abs(x);
        while (remaining != 0) {
            res = res * 10 + remaining % 10;
            remaining /= 10;
        }
        return x > 0 ? res : -res;
    }
}
