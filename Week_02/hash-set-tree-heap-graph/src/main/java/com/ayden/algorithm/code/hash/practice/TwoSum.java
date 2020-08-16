package com.ayden.algorithm.code.hash.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 两数之和
 * @author: aydenwang
 * @create: 2020-08-08 21:22
 * @version: 1.0.0
 **/
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            int num = nums[i];
            for (int i1 = i + 1; i1 < nums.length; i1++) {
                if (num == target - nums[i1]) {
                    return new int[]{i, i1};
                }
            }
        }
        return null;
    }

    public int[] twoSumHash(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Integer integer = map.get(num);
            if (integer != null) {
                return new int[]{integer, i};
            }
            map.put(target - num, i);
        }
        return null;
    }
}
