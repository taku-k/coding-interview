package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {
  private Integer[] entries;
  private Map<Integer, Integer> entriesToIdx;
  private int insertIdx;
  private Random gen;

  /** Initialize your data structure here. */
  public RandomizedSet() {
    entries = new Integer[1024];
    entriesToIdx = new HashMap<>();
    insertIdx = 0;
    gen = new Random();
  }

  /**
   * Inserts a value to the set. Returns true if the set did not already contain the specified
   * element.
   */
  public boolean insert(int val) {
    if (entriesToIdx.containsKey(val)) {
      return false;
    }
    if (insertIdx == entries.length) {
      entries = Arrays.copyOf(entries, entries.length * 2);
    }
    entriesToIdx.put(val, insertIdx);
    entries[insertIdx] = val;
    ++insertIdx;
    return true;
  }

  /** Removes a value from the set. Returns true if the set contained the specified element. */
  public boolean remove(int val) {
    if (!entriesToIdx.containsKey(val)) {
      return false;
    }
    int entryIdx = entriesToIdx.get(val);
    if (entryIdx != insertIdx - 1) {
      entries[entryIdx] = entries[insertIdx - 1];
      entriesToIdx.put(entries[insertIdx - 1], entryIdx);
    }
    entriesToIdx.remove(val);
    --insertIdx;
    return true;
  }

  /** Get a random element from the set. */
  public int getRandom() {
    return entries[gen.nextInt(insertIdx)];
  }
}
