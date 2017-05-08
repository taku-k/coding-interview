package hackerrank.ds;

import java.util.*;

public class SparseArrays {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    Map<String, Integer> m = new HashMap<>();
    while (N-- > 0) {
      String tmp = sc.next();
      m.put(tmp, m.getOrDefault(tmp, 0) + 1);
    }
    int Q = sc.nextInt();
    while (Q-- > 0) {
      String tmp = sc.next();
      System.out.println(m.getOrDefault(tmp, 0));
    }
  }
}
