package com.ayden.algorithm.code.greedy.practice;

import javax.xml.stream.events.EndDocument;

/**
 * @description: 跳跃游戏II-45
 * @author: aydenwang
 * @create: 2020-08-30 20:29
 * @version: 1.0.0
 **/
public class Jump {

    public int jump(int[] nums) {
        int step = 0;
        int length = nums.length;
        int maxPosition = 0;
        int border = 0;
        int curr = 0;
        while (curr < length - 1) {
            //到达边界之前，找到边界内能跳的最远的值
            maxPosition = Math.max(maxPosition, curr + nums[curr]);
            if (curr == border) {
                // 到达边界，用边界内跳的最远的值更新边界，表示经过这一次后，跳的最远的地方为边界
                border = maxPosition;
                step++;
            }
            curr++;
        }
        return step;
    }

}
