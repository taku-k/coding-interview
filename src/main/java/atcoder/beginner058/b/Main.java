package atcoder.beginner058.b;

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
    String o = fs.nextToken(), e = fs.nextToken();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < e.length(); i++) {
      sb.append(o.charAt(i));
      sb.append(e.charAt(i));
    }
    if (o.length() != e.length()) {
      sb.append(o.charAt(o.length() - 1));
    }
    System.out.println(sb.toString());
  }
}
