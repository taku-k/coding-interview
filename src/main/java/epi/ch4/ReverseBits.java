package epi.ch4;

public class ReverseBits {
    private static long[] precomputedReverse = new long[1 << 16];
    private static int SIZE = 16;
    private static int MASK = (1 << SIZE) - 1;

    public static long reverse(long x) {
        return precomputedReverse[(int)((x >>> (SIZE * 0)) & MASK)] << (SIZE * 3) |
                precomputedReverse[(int)((x >>> (SIZE * 1)) & MASK)] << (SIZE * 2) |
                precomputedReverse[(int)((x >>> (SIZE * 2)) & MASK)] << (SIZE * 1) |
                precomputedReverse[(int)((x >>> (SIZE * 3)) & MASK)];
    }

    public static void createPrecomputedReverse() {
        for (int i = 0; i < (1 << 16); i++) {
            long x = i;
            for (int j = 0, k = 15; j < k; j++, k--) {
                x = SwapBits.swap(x, j, k);
            }
            precomputedReverse[i] = x;
        }
    }
}
