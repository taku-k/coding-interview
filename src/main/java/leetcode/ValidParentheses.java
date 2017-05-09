package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class ValidParentheses {

  public boolean isValid(String s) {
    Deque<Character> stack = new LinkedList<>();
    for (char c : s.toCharArray()) {
      if (c == '(' || c == '{' || c == '[') {
        stack.addFirst(c);
      } else {
        if (stack.isEmpty()) {
          return false;
        }
        char temp = stack.pollFirst();
        if ((c == ')' && temp != '(') || (c == '}' && temp != '{') || (c == ']' && temp != '[')) {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }
}
