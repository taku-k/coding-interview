package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {
    /**
     * Convert an integer to arbitrary decimal integer using list
     * Most significant bit is arranged to head of list.
     * @param x
     * @return
     */
    public static List<Integer> intToList(int x) {
        if (x == 0) return Arrays.asList(0);
        int sign = x > 0 ? 1 : -1;
        x = Math.abs(x);
        List<Integer> res = new ArrayList<>();
        while (x != 0) {
            res.add(0, x % 10);
            x /= 10;
        }
        res.set(0, res.get(0) * sign);
        return res;
    }

    public static Integer listToInt(List<Integer> l) {
        int res = 0;
        int sign = l.get(0) > 0 ? 1 : -1;
        for (int i = 0; i < l.size(); ++i) {
            res = res * 10 + Math.abs(l.get(i));
        }
        return res * sign;
    }
}
