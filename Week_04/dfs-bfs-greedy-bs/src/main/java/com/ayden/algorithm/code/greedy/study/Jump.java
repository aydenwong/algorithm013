package com.ayden.algorithm.code.greedy.study;

/**
 * @description: 跳跃游戏II-45
 * @author: aydenwang
 * @create: 2020-08-30 20:29
 * @version: 1.0.0
 **/
public class Jump {

    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }



}
