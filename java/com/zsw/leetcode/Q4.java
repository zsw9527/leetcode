package com.zsw.leetcode;

/**
 *  leetcode no.4
 *  二分法 O(log(m+n))
 */
public class Q4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        boolean isJishu = (nums1.length + nums2.length) % 2 == 1;
        int len = nums1.length + nums2.length;
        if (isJishu) {
            return getK(nums1, nums2, (len+1)/2);
        } else {
            return (getK(nums1, nums2, len/2) + getK(nums1, nums2, len/2+1)) / 2.0;
        }
    }

    /**
     * 寻找两个数组中第k大的数
     * @param nums1
     * @param nums2
     * @param k
     * @return 第k大的数
     */
    private double getK(int[] nums1, int[] nums2, int k) {
        int n1 = 0;//指向nums1
        int n2 = 0;//指向nums2
        while (true) {
            //第k个数就在nums2上
            if (n1 == nums1.length) {
                return nums2[n2 + k - 1];
            }
            //第k个数就在nums1上
            if (n2 == nums2.length) {
                return nums1[n1 + k - 1];
            }
            if (k == 1) {
                return nums1[n1] < nums2[n2] ? nums1[n1] : nums2[n2];
            }
            int newIndex1 = n1 + k/2 - 1 < nums1.length - 1 ? (n1 + k/2 - 1) : nums1.length - 1;
            int newIndex2 = n2 + k/2 - 1< nums2.length - 1 ? (n2 + k/2 - 1) : nums2.length - 1;
            //比较两个数组第k/2个数的大小
            if (nums1[newIndex1] < nums2[newIndex2]) {
                //除掉nums1的前k/2个数
                k -= newIndex1 - n1 + 1;
                n1 = newIndex1 + 1;
            } else {
                //除掉nums2的前k/2个数
                k -= newIndex2 - n2 + 1;
                n2 = newIndex2 + 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        double midNum = new Q4().findMedianSortedArrays(nums1, nums2);
        System.out.println(midNum);
    }
}
