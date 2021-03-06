package atcoder.beginner057.b;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(), m = sc.nextInt();
    long[] A = new long[n], B = new long[n];
    long[] C = new long[m], D = new long[m];
    for (int i = 0; i < n; ++i) {
      A[i] = sc.nextLong();
      B[i] = sc.nextLong();
    }
    for (int i = 0; i < m; ++i) {
      C[i] = sc.nextLong();
      D[i] = sc.nextLong();
    }
    for (int i = 0; i < n; ++i) {
      long a = A[i], b = B[i];
      int res = 0;
      long max = Long.MAX_VALUE;
      for (int j = 0; j < m; ++j) {
        long c = C[j], d = D[j];
        long dist = Math.abs(a - c) + Math.abs(b - d);
        if (dist < max) {
          res = j + 1;
          max = dist;
        }
      }
      System.out.println(res);
    }
  }
}
