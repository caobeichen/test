package com.study.springcloud.leetcode.c514;

public class Solution {

    public int singleNumber(int[] nums) {
        nums = sort(nums);
        int rst = nums[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            if (i +1 <nums.length) {
                if (nums[i] == nums[i + 1]) {
                    continue;
                }
            }
            if (i - 1 >= 0) {
                if (nums[i] == nums[i - 1]) {
                    continue;
                }
            }

            rst = nums[i];
        }

        return rst;
    }

    static int[] sort(int[] nums) {
        int swap;
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (nums[i] > nums[j]) {
                    swap = nums[i];
                    nums[i] = nums[j];
                    nums[j] = swap;
                }
            }
        }

        return nums;
    }
}
