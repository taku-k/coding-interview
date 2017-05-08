package atcoder.beginner055.d;

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
  static class FastScanner {
    private final InputStream in = System.in;
    private final byte[] buffer = new byte[1024];
    private int ptr = 0;
    private int buflen = 0;

    private boolean hasNextByte() {
      if (ptr < buflen) {
        return true;
      } else {
        ptr = 0;
        try {
          buflen = in.read(buffer);
        } catch (IOException e) {
          e.printStackTrace();
        }
        if (buflen <= 0) {
          return false;
        }
      }
      return true;
    }

    private int readByte() {
      if (hasNextByte()) return buffer[ptr++];
      else return -1;
    }

    private boolean isPrintableChar(int c) {
      return 33 <= c && c <= 126;
    }

    public boolean hasNext() {
      while (hasNextByte() && !isPrintableChar(buffer[ptr])) ptr++;
      return hasNextByte();
    }

    public String next() {
      if (!hasNext()) throw new NoSuchElementException();
      StringBuilder sb = new StringBuilder();
      int b = readByte();
      while (isPrintableChar(b)) {
        sb.appendCodePoint(b);
        b = readByte();
      }
      return sb.toString();
    }

    public long nextLong() {
      if (!hasNext()) throw new NoSuchElementException();
      long n = 0;
      boolean minus = false;
      int b = readByte();
      if (b == '-') {
        minus = true;
        b = readByte();
      }
      if (b < '0' || '9' < b) {
        throw new NumberFormatException();
      }
      while (true) {
        if ('0' <= b && b <= '9') {
          n *= 10;
          n += b - '0';
        } else if (b == -1 || !isPrintableChar(b)) {
          return minus ? -n : n;
        } else {
          throw new NumberFormatException();
        }
        b = readByte();
      }
    }

    public int nextInt() {
      long nl = nextLong();
      if (nl < Integer.MIN_VALUE || nl > Integer.MAX_VALUE) throw new NumberFormatException();
      return (int) nl;
    }

    public double nextDouble() {
      return Double.parseDouble(next());
    }
  }

  public static void main(String[] args) {
    FastScanner fs = new FastScanner();
    int n = fs.nextInt();
    String s = fs.next();
    char[][] pat = {{'S', 'S'}, {'S', 'W'}, {'W', 'S'}, {'W', 'W'}};
    for (char[] p : pat) {
      String ans = check(s, p[0], p[1]);
      if (!ans.isEmpty()) {
        System.out.println(ans);
        return;
      }
    }
    System.out.println(-1);
  }

  private static String check(String s, char h1, char h2) {
    int n = s.length();
    char[] ans = new char[n];
    ans[0] = h1;
    ans[1] = h2;
    for (int i = 1; i < n - 1; ++i) {
      if (s.charAt(i) == 'o' && ans[i] == 'S') {
        ans[i + 1] = ans[i - 1];
      } else if (s.charAt(i) == 'o' && ans[i] == 'W') {
        if (ans[i - 1] == 'S') {
          ans[i + 1] = 'W';
        } else {
          ans[i + 1] = 'S';
        }
      } else if (s.charAt(i) == 'x' && ans[i] == 'S') {
        if (ans[i - 1] == 'S') {
          ans[i + 1] = 'W';
        } else {
          ans[i + 1] = 'S';
        }
      } else {
        ans[i + 1] = ans[i - 1];
      }
    }
    if (check(s, ans, n - 2, n - 1, 0) && check(s, ans, n - 1, 0, 1)) {
      return new String(ans);
    } else {
      return "";
    }
  }

  private static boolean check(String s, char[] ans, int i, int j, int k) {
    int n = s.length();
    if (s.charAt(j) == 'o' && ans[j] == 'S') {
      return ans[i] == ans[k];
    } else if (s.charAt(j) == 'o' && ans[j] == 'W') {
      return ans[i] != ans[k];
    } else if (s.charAt(j) == 'x' && ans[j] == 'S') {
      return ans[i] != ans[k];
    }
    return ans[i] == ans[k];
  }
}
