package epi.ch16;

import java.util.List;

public class ScoreCombination {
  public static int numCombinationsForFinalScore(int finalScore, List<Integer> scores) {
    //    int[][] dp = new int[scores.size()][finalScore + 1];
    //    for (int[] r : dp) {
    //      Arrays.fill(r, -1);
    //      r[0] = 1;
    //    }
    //    int res = 0;
    //    for (int i = 0; i < scores.size(); ++i) {
    //      if (finalScore - scores.get(i) >= 0) {
    //        res += rec(finalScore - scores.get(i), i, dp, scores);
    //      }
    //    }
    //    return res;
    int[][] dp = new int[scores.size()][finalScore + 1];
    for (int i = 0; i < scores.size(); ++i) {
      dp[i][0] = 1;
      for (int j = 1; j <= finalScore; ++j) {
        int without = i - 1 >= 0 ? dp[i - 1][j] : 0;
        int with = j >= scores.get(i) ? dp[i][j - scores.get(i)] : 0;
        dp[i][j] = with + without;
      }
    }
    return dp[scores.size() - 1][finalScore];
  }

  private static int rec(int score, int use, int[][] dp, List<Integer> scores) {
    if (dp[use][score] != -1) {
      return dp[use][score];
    }
    int res = 0;
    for (int i = 0; i <= use; ++i) {
      if (score - scores.get(i) >= 0) {
        res += rec(score - scores.get(i), i, dp, scores);
      }
    }
    dp[use][score] = res;
    //    System.out.println("dp[" + use + "][" + score + "] = " + res);
    return res;
  }
}
