package atcoder.beginner056.a;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next(), b = sc.next();
        String ans;
        if (a.equals("H")) {
            ans = b;
        } else {
            if (b.equals("H")) {
                ans = "D";
            } else {
                ans = "H";
            }
        }
        System.out.println(ans);
    }
}
