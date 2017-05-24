package leetcode;

import java.util.ArrayList;
import java.util.List;

public class FractionAdditionandSubtraction {
  private class Frac {
    int num;
    int den;

    Frac(int num, int den) {
      this.num = num;
      this.den = den;
    }
  }

  public String fractionAddition(String expression) {
    List<Frac> l = new ArrayList<>();
    int start = 0, i = 0;
    if (expression.charAt(0) == '-' || expression.charAt(0) == '+') {
      i = 1;
    }
    for (; i < expression.length(); ++i) {
      char c = expression.charAt(i);
      if (c == '-' || c == '+') {
        String s = expression.substring(start, i);
        l.add(gen(s));
        start = i;
      }
    }
    l.add(gen(expression.substring(start, i)));

    long den = 1;
    for (Frac f : l) {
      den *= f.den;
    }
    long num = 0;
    for (Frac f : l) {
      num += (f.num * den / f.den);
    }
    long g = Math.abs(gcd(num, den));
    return String.format("%d/%d", num / g, den / g);
  }

  private Frac gen(String s) {
    String[] split = s.split("/");
    int num = Integer.parseInt(split[0]);
    int den = Integer.parseInt(split[1]);
    return new Frac(num, den);
  }

  private long gcd(long a, long b) {
    if (a == 0) return b;
    return gcd(b % a, a);
  }
}
