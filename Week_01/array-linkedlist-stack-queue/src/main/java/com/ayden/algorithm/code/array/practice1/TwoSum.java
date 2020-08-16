package com.ayden.algorithm.code.array.practice1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @description: 两数之和
 * @author: aydenwang
 * @create: 2020-08-10 19:52
 * @version: 1.0.0
 **/
public class TwoSum {

    /**
     * 思路：
     * 遍历数组，用hash表，保存target-nums[i]的数字
     * 边遍历，边查找hash表，如果存在target-nums[i]，则表示找到了目标数字
     *
     * 时间复杂度：最坏情况下，需要遍历整个数字集合，时间复杂度O(n)
     * 空间复杂度：映入了hash表保存，时间复杂度O(n)
     *
     * 返回数字的下标，所以用map保存下标
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer integer = map.get(target - nums[i]);
            if (integer != null) {
                return new int[]{integer, i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

}
