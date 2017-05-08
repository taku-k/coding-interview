package epi.ch4;

public class SwapBits {
  public static long swap(long x, int i, int j) {
    if (((x >> i) & 0x1) != ((x >> j) & 0x1)) {
      x ^= (1L << i | 1L << j);
    }
    return x;
  }
}
