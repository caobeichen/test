package com.study.springcloud.leetcode.c137;

import java.util.HashMap;

public class Solution {

    public int singleNumber(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int rst = nums[0];

        for (int num :nums) {
            if (map.containsKey(num)) {
                map.put(num,map.get(num) +1);
            } else {
                map.put(num,1);
            }
        }

        for (int key : map.keySet()) {
            if (map.get(key) <= 1) {
                return key;
            }
        }

        return rst;
    }
}
