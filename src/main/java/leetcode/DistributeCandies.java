package leetcode;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {
    public int distributeCandies(int[] candies) {
        int result = candies.length / 2;
        Set<Integer> distinctCandies = new HashSet<>();
        for (int c : candies) {
            distinctCandies.add(c);
        }
        return Math.min(result, distinctCandies.size());
    }
}
