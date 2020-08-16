package com.ayden.algorithm.code.array.study;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @description: 两数之和
 * @create: 2020-07-28 07:56
 * @version: 1.0.0
 **/
public class TwoSum {

    /**
     * 暴力法
     * 思路：两层遍历
     * 时间复杂度：O(n2)
     * 空间复杂度：O(1)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        //第一层循环，只需要循环到倒数第二个元素即可
        for (int i = 0; i < nums.length - 1; i++) {
            //第二层循环，从第一层循环元素的后面那个开始
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * hash表
     * 使用hash表保存值和下标的映射关系，可以减少一层循环，内存循环可以直接读hash表获取值
     * 时间复杂度：O(n)
     * 空间复杂度:O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumWithHash(int[] nums, int target) {
        //用来保存元素值和下标的映射关系
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // 先看目标元素有没有在hash表中
            //为什么不会有重复问题：[5，5，6，7] target:10
            //第一个5 不会被取两次
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return null;
    }


}
