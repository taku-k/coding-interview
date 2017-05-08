package atcoder.beginner056.d;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(), k = sc.nextInt();
    long[] A = new long[n];
    for (int i = 0; i < n; ++i) {
      A[i] = sc.nextLong();
    }
    Arrays.sort(A);
    long cnt = 0;
    int i = 0;
    while (cnt < k && i < n) {
      cnt += A[i];
      ++i;
    }
    int ans = -1;
    while (cnt >= k) {
      ++ans;
      cnt -= A[ans];
    }
    if (ans == -1) {
      ans = n;
    }
    System.out.println(ans);
  }
}
