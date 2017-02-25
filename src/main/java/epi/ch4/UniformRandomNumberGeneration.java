package epi.ch4;

import java.util.Random;

public class UniformRandomNumberGeneration {
    static int zeroOneRandom() {
        Random r = new Random();
        return r.nextInt(2);
    }

    public static int rand(int a, int b) {
        int res = 0;
        int upper = b - a;
        do {
            res = 0;
            for (int i = 0; (1 << i) - 1 < upper; i++) {
                res = (res >> 1) | zeroOneRandom();
            }
        } while (res > upper);
        return res + a;
    }
}
