package atcoder.beginner057.d;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static long[][] comb = new long[51][51];
    public static void combTable() {
        for (int i = 0; i <= 50; ++i) {
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    comb[i][j] = 1;
                } else {
                    comb[i][j] = comb[i-1][j-1] + comb[i-1][j];
                }
            }
        }
    }

    public static void main(String[] args) {
        combTable();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), A = sc.nextInt(), B = sc.nextInt();
        Long[] V = new Long[N];
        for (int i = 0; i < N; ++i) {
            V[i] = sc.nextLong();
        }
        Arrays.sort(V, Collections.reverseOrder());
        int aValNum = 0, aValPos = 0;
        for (int i = 0; i < N; ++i) {
            if (V[i].equals(V[A-1])) {
                ++aValNum;
                if (i < A) {
                    ++aValPos;
                }
            }
        }
        double avg = 0.0;
        for (int i = 0; i < A; ++i) {
            avg += V[i];
        }
        avg /= A;
        long cnt = 0;
        if (aValPos == A) {
            for (aValPos = A; aValPos <= B; ++aValPos) {

                cnt += comb[aValNum][aValPos];
            }
        } else {
            cnt += comb[aValNum][aValPos];
        }
        System.out.printf("%.6f\n", avg);
        System.out.println(cnt);
    }
}

