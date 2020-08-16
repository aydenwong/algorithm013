package com.ayden.algorithm.code.array.practice;

/**
 * @description: 70 爬楼梯问题
 * @author: aydenwang
 * @create: 2020-08-10 20:03
 * @version: 1.0.0
 **/
public class ClimbStairs {

    /**
     * 递归
     * 最后一级永远是倒数第一级和倒数第二级的走法的和
     * 1.找到重复规律
     * 2.写出公式
     * 3.找到终结条件
     * 4.翻译成代码
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }


    public int climbStairsDP(int n) {
        if (n <= 2) {
            return n;
        }
        int[] stair = new int[n + 1];
        stair[1] = 1;
        stair[2] = 2;
        for (int i = 3; i <= n; i++) {
            stair[i] = stair[i - 1] + stair[i - 2];
        }
        return stair[n];
    }

    public int climbStairsDpOpt(int n) {
        if (n <= 2) {
            return n;
        }
        int count = 0;
        int pre1 = 1;
        int pre2 = 2;
        for (int i = 3; i <= n; i++) {
            count = pre1 + pre2;
            pre1 = pre2;
            pre2 = count;
        }
        return count;
    }

}
