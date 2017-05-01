package leetcode;

public class ReverseBits {
    public int reverseBits(int n) {
        for (int i = 0, j = 31; i < j; ++i, --j) {
            n = swap(n, i, j);
        }
        return n;
    }

    private int swap(int x, int i, int j) {
        if (((x >> i) & 1) != ((x >> j) & 1)) {
            int bitMask = (1 << i) | (1 << j);
            x ^= bitMask;
        }
        return x;
    }
}
