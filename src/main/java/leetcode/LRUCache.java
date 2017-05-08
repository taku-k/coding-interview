package leetcode;

import java.util.HashMap;
import java.util.Map;

/** Created by taku on 7/13/16. */
public class LRUCache {
  private Map<Integer, Node<Item>> pool;
  private DoubleLinkedList<Item> poolList;
  private int capacity;

  private class Item {
    public int key;
    public int val;

    Item(int key, int val) {
      this.key = key;
      this.val = val;
    }
  }

  public LRUCache(int capacity) {
    pool = new HashMap<>();
    poolList = new DoubleLinkedList<>();
    this.capacity = capacity;
  }

  public int get(int key) {
    if (!pool.containsKey(key)) {
      return -1;
    }
    Node<Item> n = pool.get(key);
    poolList.remove(n);
    poolList.addLast(n);
    return n.item.val;
  }

  public void set(int key, int value) {
    if (pool.containsKey(key)) {
      Node<Item> newNode = pool.get(key);
      newNode.item.val = value;
      poolList.remove(newNode);
      poolList.addLast(newNode);
    } else {
      if (pool.size() >= capacity) {
        Node<Item> evictNode = poolList.poll();
        pool.remove(evictNode.item.key);
      }
      Node<Item> newNode = new Node<>(new Item(key, value));
      pool.put(key, newNode);
      poolList.addLast(newNode);
    }
  }
}
