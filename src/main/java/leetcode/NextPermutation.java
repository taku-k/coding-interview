package leetcode;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int e = n - 2;
        while (e >= 0 && nums[e] >= nums[e + 1]) {
            --e;
        }
        if (e == -1) {
            for (int i = 0; i < n / 2; ++i) {
                swap(nums, i, n - i - 1);
            }
        } else {
            for (int i = n - 1; i > e; --i) {
                if (nums[e] < nums[i]) {
                    swap(nums, e, i);
                    break;
                }
            }
            for (int i = 0; i < (n - e) / 2; ++i) {
                swap(nums, i + e + 1, n - i - 1);
            }
        }
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
