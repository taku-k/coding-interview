package leetcode;

/**
 * Created by taku on 2016/05/25.
 */
public class MedianTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /*
         * Time complexity is O((n + m)/2) where n it the length of nums1
         * Space complexity is O(1)
         */
        int n = nums1.length, m = nums2.length;
        int m1 = -1, m2 = -1;
        int i = 0, j = 0;

        for (int count = 0; count <= (n + m)/2; count++) {
            // If the whole elements of nums1 are less than any number of nums2
            if (i == n) {
                m1 = m2;
                m2 = nums2[j];
                j++;
                continue;
            }
            // If the whole elements of nums2 are less than any number of nums1
            if (j == m) {
                m1 = m2;
                m2 = nums1[i];
                i++;
                continue;
            }

            if (nums1[i] < nums2[j]) {
                m1 = m2;
                m2 = nums1[i];
                i++;
            } else {
                m1 = m2;
                m2 = nums2[j];
                j++;
            }
        }

        if (m1 == -1) {
            return m2;
        } else if (m2 == -1) {
            return m1;
        }
        if ((n + m) % 2 != 0) {
            return m2;
        }
        return (m1 + m2) / 2.0;
    }
}
