package com.ayden.algorithm.code.greedy.study;

/**
 * @description: 跳跃游戏-55
 * @author: aydenwang
 * @create: 2020-08-30 20:27
 * @version: 1.0.0
 **/
public class CanJump {

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

}
