package epi.ch4;

public class ClosestIntSameBits {
    public static long find(long x) {
        for (int i = 0; i < 63; i++) {
            if (((x >>> i) & 1) != ((x >>> (i + 1)) & 1)) {
                return x ^ ((1L << i) | (1L << (i + 1)));
            }
        }
        throw new IllegalArgumentException("All bits are 0 or 1");
    }
}
