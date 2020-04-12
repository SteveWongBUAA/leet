/**
 * @author Steve
 * Created on 2020-04
 * <p>
 * nums1的长度是m, nums2的长度是n
 * 主要的思路，将两个数组都切分
 * <p>
 * 未完待续。。。
 */
public class No_4_findMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            // 始终让nums1是短的那个
            return findMedianSortedArrays(nums2, nums1);
        }
        int mid = (m + n + 1) / 2;
        int lo1 = 0;
        int hi1 = m;
        while (lo1 <= hi1) {
            // 定义分割线在第mid1个数前面，和第mid2个数前面
            int mid1 = (lo1 + hi1) / 2;
            int mid2 = mid - mid1;
            if (mid1 > 0 && mid2 < n && nums1[mid1 - 1] > nums2[mid2]) {
                // 往左
                hi1 = mid1 - 1;
            } else if (mid1 < m && mid2 > 0 && nums1[mid1] < nums2[mid2 - 1]) {
                // 往右
                lo1 = mid1 + 1;
            } else {
                // 不能往左也不能往右了，可能是啥？ 第一个数组走到两边了，或者符合要求了
                int maxLeft;
                if (mid1 == 0) {
                    maxLeft = nums2[mid2 - 1];
                } else if (mid2 == 0) {
                    maxLeft = nums1[mid1 - 1];
                } else {
                    maxLeft = Math.max(nums1[mid1 - 1], nums2[mid2 - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight;
                if (mid1 == m) {
                    minRight = nums2[mid2];
                } else if (mid2 == n) {
                    minRight = nums1[mid1];
                } else {
                    minRight = Math.min(nums1[mid1], nums2[mid2]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

}
