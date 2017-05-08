package epi.ch4;

public class MultiplyShiftAdd {
  public static long multiply(long x, long y) {
    long res = 0;
    for (int i = 0; i < 64; i++) {
      if ((y & 1) != 0) {
        res = add(res, x);
      }
      y >>>= 1;
      x <<= 1;
    }
    return res;
  }

  public static long add(long x, long y) {
    long carryin = 0, res = 0, i = 1;
    for (int j = 0; j < 64; j++) {
      long xx = x & 1, yy = y & 1;
      if ((xx ^ yy ^ carryin) == 1) {
        res |= i;
      }
      carryin = (xx & yy) | (xx & carryin) | (yy & carryin);
      i <<= 1;
      x >>>= 1;
      y >>>= 1;
    }
    return res;
  }
}
