package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountPrimes {
    public int countPrimes(int n) {
        if (n == 0 || n == 1) return 0;
        int primes = 0;
        List<Boolean> isPrime = new ArrayList<>(Collections.nCopies(n + 1, true));
        isPrime.set(0, false);
        isPrime.set(1, false);
        for (int p = 2; p < n; ++p) {
            if (isPrime.get(p)) {
                ++primes;
                for (int i = p * 2; i < n; i += p) {
                    isPrime.set(i, false);
                }
            }
        }
        return primes;
    }
}
