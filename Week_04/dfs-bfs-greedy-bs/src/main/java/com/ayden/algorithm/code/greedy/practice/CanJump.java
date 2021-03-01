package com.ayden.algorithm.code.greedy.practice;

/**
 * @description: 跳跃游戏-55
 * @author: aydenwang
 * @create: 2020-08-30 20:27
 * @version: 1.0.0
 **/
public class CanJump {

    public boolean canJump(int[] nums) {

        int length = nums.length;
        int mostPosition = 0;

        for (int curr = 0; curr < nums.length; curr++) {
            if (curr <= mostPosition) {
                mostPosition = Math.max(mostPosition, curr + nums[curr]);
                if (mostPosition >= length - 1) {
                    return true;
                }
            }
        }

        return false;
    }

}
