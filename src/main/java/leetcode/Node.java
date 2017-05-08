package leetcode;

/** Created by taku on 7/16/16. */
public class Node<Item> {
  public Item item;
  public Node<Item> prev;
  public Node<Item> next;

  Node(Item item) {
    this.item = item;
  }

  Node() {}
}
