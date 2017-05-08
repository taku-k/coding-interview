package atcoder.beginner056.c;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long x = sc.nextLong();
    long cnt = 0;
    long ans = 0;
    while (cnt < x) {
      ++ans;
      cnt += ans;
    }
    System.out.println(ans);
  }
}
