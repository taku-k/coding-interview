package leetcode;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {

  Map<Integer, Integer> keyToVal;
  Map<Integer, Integer> keyRefCount;
  Map<Integer, LinkedHashSet<Integer>> refCountToKeys;
  int minEvictedCount;
  int capacity;

  public LFUCache(int capacity) {
    keyToVal = new HashMap<>();
    keyRefCount = new HashMap<>();
    refCountToKeys = new HashMap<>();
    this.capacity = capacity;
    minEvictedCount = 0;
  }

  public int get(int key) {
    if (!keyToVal.containsKey(key)) {
      return -1;
    }
    int refCount = keyRefCount.get(key);
    keyRefCount.put(key, refCount + 1);
    LinkedHashSet<Integer> sameRefCountKeys = refCountToKeys.get(refCount);
    sameRefCountKeys.remove(key);
    if (sameRefCountKeys.size() == 0 && minEvictedCount == refCount) {
      minEvictedCount = refCount + 1;
    }
    refCountToKeys.putIfAbsent(refCount + 1, new LinkedHashSet<>());
    refCountToKeys.get(refCount + 1).add(key);
    return keyToVal.get(key);
  }

  public void put(int key, int value) {
    if (capacity <= 0) {
      return;
    }
    if (keyToVal.containsKey(key)) {
      keyToVal.put(key, value);
      get(key);
      return;
    }
    if (keyToVal.size() == capacity) {
      // Eviction
      int evictKey = refCountToKeys.get(minEvictedCount).iterator().next();
      refCountToKeys.get(minEvictedCount).remove(evictKey);
      keyToVal.remove(evictKey);
      keyRefCount.remove(evictKey);
    }
    keyToVal.put(key, value);
    keyRefCount.put(key, 1);
    minEvictedCount = 1;
    refCountToKeys.putIfAbsent(1, new LinkedHashSet<>());
    refCountToKeys.get(1).add(key);
  }
}
