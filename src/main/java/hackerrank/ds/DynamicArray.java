package hackerrank.ds;

import java.io.*;
import java.util.*;

public class DynamicArray {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int Q = sc.nextInt();
    int lastAns = 0;
    List<List<Integer>> seqs = new ArrayList<>();
    for (int i = 0; i < N; i++) seqs.add(new ArrayList<>());
    while (Q-- > 0) {
      int query = sc.nextInt();
      int x = sc.nextInt();
      int y = sc.nextInt();
      if (query == 1) {
        List<Integer> seq = seqs.get((x ^ lastAns) % N);
        seq.add(y);
      } else {
        List<Integer> seq = seqs.get((x ^ lastAns) % N);
        lastAns = seq.get(y % seq.size());
        System.out.println(lastAns);
      }
    }
  }
}
