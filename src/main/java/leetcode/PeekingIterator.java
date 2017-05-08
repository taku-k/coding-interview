package leetcode;

import java.util.Iterator;

/** Created by taku on 7/26/16. */
public class PeekingIterator implements Iterator<Integer> {
  private Integer val;
  private Boolean hasPeek;
  private Iterator<Integer> iterator;

  public PeekingIterator(Iterator<Integer> iterator) {
    // initialize any member here.
    hasPeek = false;
    this.iterator = iterator;
  }

  // Returns the next element in the iteration without advancing the iterator.
  public Integer peek() {
    if (!hasPeek) {
      hasPeek = true;
      val = iterator.next();
    }
    return val;
  }

  // hasNext() and next() should behave the same as in the Iterator interface.
  // Override them if needed.
  @Override
  public Integer next() {
    Integer ret = peek();
    hasPeek = false;
    return ret;
  }

  @Override
  public boolean hasNext() {
    return hasPeek || iterator.hasNext();
  }
}
