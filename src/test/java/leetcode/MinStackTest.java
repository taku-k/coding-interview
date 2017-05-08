package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

/** Created by taku on 7/19/16. */
public class MinStackTest {
  @Test
  public void test() {
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    assertEquals(minStack.getMin(), -3);
    minStack.pop();
    assertEquals(minStack.top(), 0);
    assertEquals(minStack.getMin(), -2);
  }
}
