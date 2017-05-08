package leetcode;

/** Created by taku on 7/11/16. */
public class ZigZagConversion {
  public String convert(String s, int numRows) {
    StringBuilder[] rows = new StringBuilder[numRows];
    for (int i = 0; i < numRows; i++) {
      rows[i] = new StringBuilder();
    }
    int index = 0;
    int dir = -1;
    if (numRows == 1) dir = 0;
    for (int i = 0; i < s.length(); i++) {
      rows[index].append(s.charAt(i));
      if (index == 0) dir += 2;
      if (index == numRows - 1) dir -= 2;
      index += dir;
    }
    StringBuilder ret = new StringBuilder();
    for (StringBuilder sb : rows) {
      ret.append(sb.toString());
    }
    return ret.toString();
  }
}
