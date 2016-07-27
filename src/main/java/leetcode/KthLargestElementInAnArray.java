package leetcode;

import java.util.Arrays;

/**
 * Created by taku on 7/12/16.
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
