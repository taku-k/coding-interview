package epi.ch4;

public class Division {
    public static long div(long x, long y) {
        long res = 0;
        int power = 32;
        long yPower = y << power;
        while (x >= y) {
            while (yPower > x) {
                yPower >>>= 1;
                power--;
            }
            res += 1 << power;
            x -= yPower;
        }
        return res;
    }
}
