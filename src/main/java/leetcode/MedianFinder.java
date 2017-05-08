package leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

/** Created by taku on 7/27/16. */
public class MedianFinder {
  private PriorityQueue<Integer> maxHeap, minHeap;

  public MedianFinder() {
    maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    minHeap = new PriorityQueue<>();
  }

  // Adds a number into the data structure.
  public void addNum(int num) {
    if (maxHeap.size() == 0) {
      maxHeap.add(num);
    } else if (maxHeap.peek() < num) {
      minHeap.add(num);
    } else {
      maxHeap.add(num);
    }

    if (Math.abs(maxHeap.size() - minHeap.size()) > 1) {
      if (maxHeap.size() > minHeap.size()) {
        minHeap.add(maxHeap.poll());
      } else {
        maxHeap.add(minHeap.poll());
      }
    }
  }

  // Returns the median of current data stream
  public double findMedian() {
    if (maxHeap.size() == 0) {
      return 0.0;
    }
    if (maxHeap.size() == minHeap.size()) {
      return (maxHeap.peek() + minHeap.peek()) / 2.0;
    } else if (maxHeap.size() > minHeap.size()) {
      return (double) maxHeap.peek();
    } else {
      return (double) minHeap.peek();
    }
  }
}
