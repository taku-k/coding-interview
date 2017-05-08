package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    directedGenParenthesis("", n, n, result);
    return result;
  }

  private void directedGenParenthesis(
      String parenthesis, int numsRightNeeded, int numsLeftNeeded, List<String> result) {
    if (numsLeftNeeded == 0 && numsRightNeeded == 0) {
      result.add(parenthesis);
      return;
    }
    if (numsLeftNeeded > 0) {
      directedGenParenthesis(
          parenthesis + "(", numsRightNeeded,
          numsLeftNeeded - 1, result);
    }
    if (numsLeftNeeded < numsRightNeeded) {
      directedGenParenthesis(parenthesis + ")", numsRightNeeded - 1, numsLeftNeeded, result);
    }
  }
}
