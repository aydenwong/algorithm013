package com.ayden.algorithm.code.array.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 四数之和
 * @author: aydenwang
 * @create: 2020-08-30 19:31
 * @version: 1.0.0
 **/
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        //排序
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            //对于重复元素：跳过，避免出现重复解
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //4sum相比3sum  多一个for循环
            for (int j = i + 1; j < len; j++) {
                //去掉重复元素
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                //左指针L=j+1！！！右指针 R=n-1，当 L<R时，执行循环
                int L = j + 1, R = len - 1;
                while (L < R) {
                    int tmp = nums[i] + nums[j] + nums[L] + nums[R];
                    if (tmp > target) {
                        R--;
                    } else if (tmp < target) {
                        L++;
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[L]);
                        list.add(nums[R]);
                        lists.add(list);

                        while (L < R && nums[L + 1] == nums[L]) {
                            L++;
                        }
                        while (L < R && nums[R - 1] == nums[R]) {
                            R--;
                        }
                        L++;
                        R--;
                    }
                }
            }
        }
        return lists;
    }

}
