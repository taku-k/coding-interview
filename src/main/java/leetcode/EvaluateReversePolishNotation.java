package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class EvaluateReversePolishNotation {

  public int evalRPN(String[] tokens) {
    Deque<Integer> stack = new LinkedList<>();
    for (String token : tokens) {
      if (token.length() == 1 && "+-*/".contains(token)) {
        int x = stack.pollFirst();
        int y = stack.pollFirst();
        int result = 0;
        switch (token.charAt(0)) {
          case '+':
            result = x + y;
            break;
          case '-':
            result = x - y;
            break;
          case '*':
            result = x * y;
            break;
          case '/':
            result = x / y;
            break;
        }
        stack.addFirst(result);
      } else {
        stack.addFirst(Integer.parseInt(token));
      }
    }
    return stack.pollFirst();
  }
}
