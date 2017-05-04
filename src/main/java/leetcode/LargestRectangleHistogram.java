package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class LargestRectangleHistogram {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> pillarIndices = new LinkedList<>();
        int maxRectangle = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (!pillarIndices.isEmpty() && heights[i] == heights[pillarIndices.peekFirst()]) {
                pillarIndices.pollFirst();
            }
            while (!pillarIndices.isEmpty() && heights[i] < heights[pillarIndices.peekFirst()]) {
                int height = heights[pillarIndices.pollFirst()];
                int width = pillarIndices.isEmpty() ? i : i - pillarIndices.peekFirst() - 1;
                maxRectangle = Math.max(maxRectangle, height * width);
            }
            pillarIndices.addFirst(i);
        }
        while (!pillarIndices.isEmpty()) {
            int height = heights[pillarIndices.pollFirst()];
            int width = pillarIndices.isEmpty() ? heights.length : heights.length - pillarIndices.peekFirst() - 1;
            maxRectangle = Math.max(maxRectangle, height * width);
        }
        return maxRectangle;
    }
}
