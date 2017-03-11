package epi.ch5;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static List<Integer> matrixInSpiralOrder(List<List<Integer>> square) {
        List<Integer> ordering = new ArrayList<>();
        for (int i = 0; i < Math.ceil(square.size() / 2.0); ++i) {
            subMatrixInClockwise(square, i, ordering);
        }
        return ordering;
    }

    private static void subMatrixInClockwise(List<List<Integer>> square, int offset, List<Integer> ordering) {
        int n = square.size();
        for (int i = offset; i < n - offset; ++i) {
            ordering.add(square.get(offset).get(i));
        }
//        for (int i = )
    }
}
