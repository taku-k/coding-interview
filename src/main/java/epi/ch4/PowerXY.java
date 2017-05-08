package epi.ch4;

public class PowerXY {
  public static double power(double x, int y) {
    double result = 1.0;
    if (y < 0) {
      y = -y;
      x = 1.0 / x;
    }
    while (y != 0) {
      if ((y & 1) != 0) {
        result *= x;
      }
      x *= x;
      y >>>= 1;
    }
    return result;
  }
}
