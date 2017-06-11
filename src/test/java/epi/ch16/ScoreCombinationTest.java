package epi.ch16;

import static epi.ch16.ScoreCombination.numCombinationsForFinalScore;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.junit.Test;

public class ScoreCombinationTest {
  @Test
  public void simpleTest() {
    List<Integer> individualPlayScores = Arrays.asList(2, 3, 7);
    assertEquals(4, numCombinationsForFinalScore(12, individualPlayScores));
    assertEquals(1, numCombinationsForFinalScore(5, individualPlayScores));
    assertEquals(3, numCombinationsForFinalScore(9, individualPlayScores));
  }

  @Test
  public void test() {
    Random r = new Random();
    for (int times = 0; times < 1000; ++times) {
      int k;
      Set<Integer> individualPlayScoresSet = new HashSet<>();
      k = r.nextInt(1000);
      int size = r.nextInt(50) + 1;
      for (int i = 0; i < size; ++i) {
        individualPlayScoresSet.add(r.nextInt(1000) + 1);
      }

      List<Integer> individualPlayScores = new ArrayList<>(individualPlayScoresSet);
      //    System.out.println(numCombinationsForFinalScore(k, individualPlayScores));
      assertEquals(
          checkAnswer(k, individualPlayScores),
          numCombinationsForFinalScore(k, individualPlayScores));
    }
  }

  private static int checkAnswer(int totalScore, List<Integer> scoreWays) {
    int[] combinations = new int[totalScore + 1];
    combinations[0] = 1; // One way to reach 0.
    for (int score : scoreWays) {
      for (int j = score; j <= totalScore; ++j) {
        combinations[j] += combinations[j - score];
      }
    }
    return combinations[totalScore];
  }
}
