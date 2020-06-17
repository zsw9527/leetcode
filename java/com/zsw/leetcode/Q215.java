package com.zsw.leetcode;

public class Q215 {

    public int findKthLargest(int[] nums, int k) {
        int res = 0;
        int left = 0;
        int right = nums.length - 1;
        while (true) {
            int pos = posititation(nums, left, right);
            if (pos < k-1) {
                left = pos+1;
            } else if (pos > k-1) {
                right = pos-1;
            } else {
                res = pos;
                break;
            }
        }
        return nums[res];
    }

    public int posititation(int[] nums, int left, int right) {
        int tmp = nums[left];
        while (left < right) {
            while (left < right && tmp <= nums[right]) {
                right--;
            }
            nums[left++] = nums[right];
            while (left < right && tmp >= nums[left]) {
                left++;
            }
            nums[right--] = nums[left];
        }
        nums[left] = tmp;
        return left;
    }

    public void sort(int[] nums, int left, int right) {
        if (left < right) {
            int pos = posititation(nums, left, right);
            sort(nums, left, pos - 1);
            sort(nums, pos + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        new Q215().sort(nums, 0, 5);
        for (int tmp : nums) {
            System.out.print(tmp + " ");
        }
    }
}
