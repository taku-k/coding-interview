package leetcode;

public class BitwiseANDNumbersRange {
  public int rangeBitwiseAnd(int m, int n) {
    int result = 0;
    for (int i = 31; i >= 0; --i) {
      if (((m >> i) & 1) != ((n >> i) & 1)) break;
      if (((m >> i) & 1) == 1) {
        result |= 1 << i;
      }
    }
    return result;
  }
}
