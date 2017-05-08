package leetcode;

/** Created by taku on 7/11/16. */
public class ReverseInteger {
  public int reverse(int x) {
    int res = 0;
    int remaining = Math.abs(x);
    while (remaining != 0) {
      int cur = res * 10 + remaining % 10;
      if ((cur - remaining % 10) / 10 != res) return 0;
      remaining /= 10;
    }
    return x > 0 ? res : -res;
  }
}
