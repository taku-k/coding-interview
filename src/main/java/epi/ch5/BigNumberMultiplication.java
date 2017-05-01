package epi.ch5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BigNumberMultiplication {
    public static List<Integer> multiply(List<Integer> list1, List<Integer> list2) {
        List<Integer> res = new ArrayList<>(Collections.nCopies(list1.size() + list2.size(), 0));
        int sign = (list1.get(0) > 0) ^ (list2.get(0) > 0) ? -1 : 1;
        list1.set(0, Math.abs(list1.get(0)));
        list2.set(0, Math.abs(list2.get(0)));
        for (int i = list2.size() - 1; i >= 0; --i) {
            for (int j = list1.size() - 1; j >= 0; --j) {
                int carryin = res.get(i + j + 1);
                int tmp = list1.get(j) * list2.get(i) + carryin;
                res.set(i + j + 1, tmp % 10);
                res.set(i + j, res.get(i + j) + tmp / 10);

            }
        }
        // Delete leading zeros
        int firstNonZeroIndex = 0;
        while (firstNonZeroIndex < res.size() && res.get(firstNonZeroIndex) == 0) {
            ++firstNonZeroIndex;
        }
        res = res.subList(firstNonZeroIndex, res.size());
        if (res.isEmpty()) {
            return Arrays.asList(0);
        }
        res.set(0, res.get(0) * sign);
        return res;
    }
}
