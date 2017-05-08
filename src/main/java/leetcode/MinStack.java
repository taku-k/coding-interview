package leetcode;

import java.util.LinkedList;

/** Created by taku on 7/19/16. */
public class MinStack {

  private LinkedList<Item> list;

  private class Item {
    public int val;
    public int min;

    Item(int val, int min) {
      this.val = val;
      this.min = min;
    }
  }

  public MinStack() {
    this.list = new LinkedList<>();
  }

  public void push(int x) {
    if (this.list.isEmpty()) {
      this.list.addFirst(new Item(x, x));
    } else {
      Item first = this.list.peek();
      this.list.addFirst(new Item(x, Math.min(first.min, x)));
    }
  }

  public void pop() {
    this.list.poll();
  }

  public int top() {
    if (this.list.isEmpty()) {
      return -1;
    } else {
      return this.list.peek().val;
    }
  }

  public int getMin() {
    if (this.list.isEmpty()) {
      return -1;
    } else {
      return this.list.peek().min;
    }
  }
}
