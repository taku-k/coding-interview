package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PermutationKthSequence {
  public String getPermutation(int n, int k) {
    List<Integer> num = new ArrayList<>();
    for (int i = 1; i <= n; ++i) {
      num.add(i);
    }
    int[] fact = new int[n];
    fact[0] = 1;
    for (int i = 1; i < n; ++i) {
      fact[i] = i * fact[i - 1];
    }
    k--;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n - 1; ++i) {
      sb.append(num.get(k / fact[n - 1 - i]));
      num.remove(k / fact[n - 1 - i]);
      k %= fact[n - 1 - i];
    }
    return sb.toString();
  }
}
