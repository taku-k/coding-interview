package hackerrank.ds;

import java.util.*;
import java.io.*;

public class LeftRotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(array[(i+d) % n]);
            if (i != n-1) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}
