package leetcode;

public class RangeSumQuery {
  int[] tree;
  int n;

  public RangeSumQuery(int[] nums) {
    if (nums.length > 0) {
      n = nums.length;
      tree = new int[n * 2];
      buildTree(nums);
    }
  }

  private void buildTree(int[] nums) {
    for (int i = n, j = 0; i < 2 * n; ++i, ++j) {
      tree[i] = nums[j];
    }
    for (int i = n - 1; i > 0; --i) {
      tree[i] = tree[2 * i] + tree[2 * n + 1];
    }
  }

  public void update(int i, int val) {
    int diff = val - tree[n + i];
    int idx = n + i;
    while (idx != 0) {
      tree[idx] += diff;
      idx /= 2;
    }
  }

  public int sumRange(int l, int r) {
    l += n;
    // get leaf with value 'r'
    r += n;
    int sum = 0;
    while (l <= r) {
      if ((l % 2) == 1) {
        sum += tree[l];
        l++;
      }
      if ((r % 2) == 0) {
        sum += tree[r];
        r--;
      }
      l /= 2;
      r /= 2;
    }
    return sum;
  }
}
