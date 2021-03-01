package com.ayden.algorithm.code.greedy.practice1;

/**
 * @description: 跳跃游戏II-45
 * @author: aydenwang
 * @create: 2020-08-30 20:29
 * @version: 1.0.0
 **/
public class Jump {

    public int jump(int[] nums) {
        int length = nums.length;
        int border = 0;
        int maxPosition = 0;
        int curr = 0;
        int steps =0;

        while (maxPosition < length - 1) {
            maxPosition = Math.max(maxPosition, curr + nums[curr]);
            if (curr == border) {
                border = maxPosition;
                steps++;
            }
            curr++;
        }

        return steps;
    }

}
