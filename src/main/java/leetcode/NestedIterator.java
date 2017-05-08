package leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/** Created by taku on 7/27/16. */
public class NestedIterator implements Iterator<Integer> {

  // This is the interface that allows for creating nested lists.
  // You should not implement it, or speculate about its implementation
  private interface NestedInteger {
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();
    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();
    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
  }

  private LinkedList<Integer> list;
  private Iterator<Integer> iter;

  public NestedIterator(List<NestedInteger> nestedIteratorList) {
    list = new LinkedList<>();
    dfs(nestedIteratorList);
    iter = list.iterator();
  }

  private void dfs(List<NestedInteger> nl) {
    for (NestedInteger ni : nl) {
      if (ni.isInteger()) {
        list.add(ni.getInteger());
      } else {
        dfs(ni.getList());
      }
    }
  }

  @Override
  public Integer next() {
    return iter.next();
  }

  @Override
  public boolean hasNext() {
    return iter.hasNext();
  }
}
