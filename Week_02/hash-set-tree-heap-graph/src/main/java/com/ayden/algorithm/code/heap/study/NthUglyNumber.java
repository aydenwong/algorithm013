package com.ayden.algorithm.code.heap.study;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @description: 丑数
 * @author: aydenwang
 * @create: 2020-08-09 20:33
 * @version: 1.0.0
 **/
public class NthUglyNumber {

    /**
     * 堆实现
     *
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        Queue<Long> queue = new PriorityQueue<Long>();
        int count = 0;
        long result = 1;
        queue.add(result);
        while (count < n) {
            result = queue.poll();
            // 删除重复的
            while (!queue.isEmpty() && result == queue.peek()) {
                queue.poll();
            }
            count++;
            queue.offer(result * 2);
            queue.offer(result * 3);
            queue.offer(result * 5);
        }
        return (int) result;
    }

    /**
     * 动态规划方法
     *
     * @param n
     * @return
     */
    public int nthUglyNumberDp(int n) {
        int[] ugly = new int[n];
        // 丑数序列
        ugly[0] = 1;
        //三个指针
        int index2 = 0, index3 = 0, index5 = 0;
        for (int i = 1; i < n; i++) {
            // 三个中选择较小的
            int factor2 = 2 * ugly[index2];
            int factor3 = 3 * ugly[index3];
            int factor5 = 5 * ugly[index5];
            int min = Math.min(Math.min(factor2, factor3), factor5);
            //更新丑数序列
            ugly[i] = min;
            if (factor2 == min) {
                index2++;
            }
            if (factor3 == min) {
                index3++;
            }
            if (factor5 == min) {
                index5++;
            }
        }
        return ugly[n - 1];
    }


}
