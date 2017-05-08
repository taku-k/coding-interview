package leetcode;

/** Created by taku on 7/16/16. */
public class DoubleLinkedList<Item> {

  private Node<Item> head;
  private Node<Item> tail;

  DoubleLinkedList() {
    head = new Node<>();
    tail = new Node<>();
    head.next = tail;
    tail.prev = head;
  }

  public void addLast(Node<Item> n) {
    Node<Item> tailPrev = tail.prev;
    tailPrev.next = n;
    n.prev = tailPrev;
    n.next = tail;
    tail.prev = n;
  }

  public void addFirst(Node<Item> n) {
    Node<Item> headNext = head.next;
    head.next = n;
    n.prev = head;
    n.next = headNext;
    headNext.prev = n;
  }

  public void remove(Node<Item> n) {
    Node<Item> nPrev = n.prev;
    Node<Item> nNext = n.next;
    nPrev.next = nNext;
    nNext.prev = nPrev;
  }

  public Node<Item> poll() {
    if (head.next == head) {
      return null;
    }
    Node<Item> first = head.next;
    remove(first);
    return first;
  }
}
