package epi.ch14;

import java.util.List;
import java.util.TreeSet;

public class MinimumDistanceSortedArrays {
  private static class Entry implements Comparable<Entry> {
    int n;
    int arrayIdx;
    int idx;

    Entry(int n, int arrayIdx, int idx) {
      this.n = n;
      this.arrayIdx = arrayIdx;
      this.idx = idx;
    }

    @Override
    public int compareTo(Entry o) {
      int result = Integer.compare(this.n, o.n);
      if (result == 0) {
        return Integer.compare(arrayIdx, o.arrayIdx);
      }
      return result;
    }

    @Override
    public boolean equals(Object o) {
      if (o == null || !(o instanceof Entry)) {
        return false;
      }
      if (this == o) {
        return true;
      }
      Entry e = (Entry) o;
      return n == e.n && arrayIdx == e.arrayIdx && idx == e.idx;
    }
  }

  public static int findMinDistanceSortedArrays(List<List<Integer>> sortedArrays) {
    if (sortedArrays.size() == 0 || sortedArrays.get(0).size() == 0) {
      return 0;
    }
    TreeSet<Entry> tree = new TreeSet<>();
    int result = Integer.MAX_VALUE;
    for (int i = 0; i < sortedArrays.size(); ++i) {
      if (sortedArrays.get(i).size() != 0) {
        Entry entry = new Entry(sortedArrays.get(i).get(0), i, 0);
        tree.add(entry);
      }
    }
    while (true) {
      result = Math.min(result, tree.last().n - tree.first().n);
      Entry entry = tree.pollFirst();
      if (entry.idx + 1 == sortedArrays.get(entry.arrayIdx).size()) {
        return result;
      }
      ++entry.idx;
      int n = sortedArrays.get(entry.arrayIdx).get(entry.idx);
      tree.add(new Entry(n, entry.arrayIdx, entry.idx));
    }
  }
}
