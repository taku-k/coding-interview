package atcoder.beginner056.b;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt(), a = sc.nextInt(), b = sc.nextInt();
        int ans;
        if (a + w < b) {
            ans = b - a - w;
        } else if (b + w < a) {
            ans = a - b - w;
        } else {
            ans = 0;
        }
        System.out.println(ans);
    }
}
