package atcoder.beginner058.c;

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
  public static class FastScanner {
    BufferedReader br;
    StringTokenizer st;

    public FastScanner(String s) {
      try {
        br = new BufferedReader(new FileReader(s));
      } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }

    public FastScanner() {
      br = new BufferedReader(new InputStreamReader(System.in));
    }

    String nextToken() {
      while (st == null || !st.hasMoreElements()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    int nextInt() {
      return Integer.parseInt(nextToken());
    }

    long nextLong() {
      return Long.parseLong(nextToken());
    }

    double nextDouble() {
      return Double.parseDouble(nextToken());
    }
  }

  public static void main(String[] args) {
    FastScanner fs = new FastScanner();
    int n = fs.nextInt();
    int[][] charsCount = new int[n][26];
    for (int i = 0; i < n; ++i) {
      String s = fs.nextToken();
      for (int j = 0; j < s.length(); ++j) {
        charsCount[i][s.charAt(j) - 'a']++;
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int j = 0; j < 26; ++j) {
      int min = Integer.MAX_VALUE;
      for (int i = 0; i < n; ++i) {
        min = Math.min(min, charsCount[i][j]);
      }
      while (min-- > 0) {
        sb.append((char) (j + 'a'));
      }
    }
    System.out.println(sb.toString());
  }
}
