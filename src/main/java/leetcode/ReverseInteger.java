package leetcode;

/**
 * Created by taku on 7/11/16.
 */
public class ReverseInteger {
    public int reverse(int x) {
        StringBuilder sb = new StringBuilder();
        if (x < 0) {
            sb.append("-");
            x *= -1;
        }
        String xs = Integer.toString(x);
        for (int i = xs.length()-1; i >= 0; i--) {
            sb.append(xs.charAt(i));
        }
        int ret = 0;
        try {
            ret = Integer.valueOf(sb.toString());
        } catch (Exception e) {
            ret = 0;
        }
        return ret;
    }
}