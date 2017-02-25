package epi.ch5;

import java.util.List;

public class PermutationArray {
    public static void apply(List<Integer> A, List<Integer> perm) {
        for (int i = 0; i < A.size(); ++i) {
            int temp = A.get(i);
            int next = i;
            while (perm.get(next) >= 0) {
                int tmp = A.get(perm.get(next));
                A.set(perm.get(next), temp);
                temp = tmp;
                int tempNext = perm.get(next);
                perm.set(next, perm.get(next) - perm.size());
                next = tempNext;
            }
        }

        for (int i = 0; i < perm.size(); ++i) {
            perm.set(i, perm.get(i) + perm.size());
        }
    }
}
