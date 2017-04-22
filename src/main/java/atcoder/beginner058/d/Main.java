package atcoder.beginner058.d;

import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    private static long MOD = 1000000007L;

    public static void main(String[] args) {
        Scanner fs = new Scanner(System.in);
        int n = fs.nextInt(), m = fs.nextInt();
        System.out.println((helper(fs, n) * helper(fs, m)) % MOD);
    }

    private static long helper(Scanner fs, int n) {
        long ans = 0L;
        Long[] xx = new Long[n];
        for (int i = 0; i < n; ++i) {
            xx[i] = fs.nextLong();
        }
        Arrays.sort(xx);
        long prev = xx[0];
        for (int i = 1; i < n; ++i) {
            long x = xx[i];
            long tmp = (x - prev) * i % MOD;
            tmp = tmp * (n - i) % MOD;
            ans = (ans + tmp) % MOD;
            prev = x;
        }
        return ans;
    }
}
