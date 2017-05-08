package leetcode;

public class SquirrelSimulation {
  public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
    int firstNutsIdx = 0;
    int dist = 0;
    int result = Integer.MAX_VALUE;
    int[] dists = new int[nuts.length];
    for (int i = 0; i < nuts.length; ++i) {
      dists[i] = (Math.abs(tree[0] - nuts[i][0]) + Math.abs(tree[1] - nuts[i][1])) * 2;
      dist += dists[i];
    }
    for (int[] n : nuts) {
      int td = Math.abs(tree[0] - n[0]) + Math.abs(tree[1] - n[1]);
      int sd = Math.abs(squirrel[0] - n[0]) + Math.abs(squirrel[1] - n[1]);
      result = Math.min(result, dist - td + sd);
    }
    return result;
  }
}
