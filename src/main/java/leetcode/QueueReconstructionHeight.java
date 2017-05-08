package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class QueueReconstructionHeight {
  public int[][] reconstructQueue(int[][] people) {
    Arrays.sort(
        people,
        new Comparator<int[]>() {
          @Override
          public int compare(int[] o1, int[] o2) {
            if (o1[0] != o2[0]) {
              return Integer.compare(o1[0], o2[0]);
            }
            return Integer.compare(o1[1], o2[1]);
          }
        });
    int[][] res = new int[people.length][2];
    for (int[] r : res) {
      Arrays.fill(r, -1);
    }
    for (int i = 0; i < people.length; ++i) {
      int h = people[i][0], k = people[i][1];
      for (int j = 0; j < people.length; ++j) {
        if ((res[j][0] == -1 && res[j][1] == -1) || (res[j][0] == h)) {
          k--;
          if (k < 0) {
            res[j][0] = h;
            res[j][1] = people[i][1];
            break;
          }
        }
      }
    }
    return res;
  }
}
