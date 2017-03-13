package leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class SortedMatrixKSmallest {
    private class MatrixElement implements Comparable<MatrixElement> {
        int value;
        int x;
        int y;

        public MatrixElement(int value, int x, int y) {
            this.value = value;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(MatrixElement o) {
            return Integer.compare(this.value, o.value);
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        if (n == 0) return 0;
        PriorityQueue<MatrixElement> minHeap = new PriorityQueue<>();
        for (int y = 0; y < n; ++y) {
            minHeap.add(new MatrixElement(matrix[y][0], 0, y));
        }
        for (int i = 2; i <= k; ++i) {
            MatrixElement elem = minHeap.poll();
            int x = elem.x;
            int y = elem.y;
            if (x + 1 < n) {
                minHeap.add(new MatrixElement(matrix[y][x + 1], x + 1, y));
            }
        }
        return minHeap.peek().value;
    }
}
