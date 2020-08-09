package code.ayden.algorithm.com.heap.practice;

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
        // 思路：每算出第i个丑数u，都把u*2,u*3,u*5加到一个小顶堆中，每次取出小顶堆堆顶最小的丑数
        // 因为所有的丑数，都是当前的丑数u -> u*2,u*3,u*5 生成的。
        // 注意丑数有可能重复
        PriorityQueue<Long> heap = new PriorityQueue<>();
        long u = 1;
        heap.add(u);
        for (int i = 0; i < n; i++) {
            u = heap.poll();
            if (i == n - 1) {
                return (int) u;
            }
            while (!heap.isEmpty() && u == heap.peek()) {
                heap.poll();
            }
            heap.add(u * 2);
            heap.add(u * 3);
            heap.add(u * 5);
        }
        return (int) u;
    }

    /**
     * 动态规划方法
     *
     * @param n
     * @return
     */
    public int nthUglyNumberDp(int n) {
        int ugly[] = new int[n];

        ugly[0] = 1;

        int index2 = 0, index3 = 0, index5 = 0;

        for (int i = 1; i < n; i++) {

            int u2 = 2 * ugly[index2];
            int u3 = 3 * ugly[index3];
            int u5 = 5 * ugly[index5];

            int min = Math.min(Math.min(u2, u3), u5);

            ugly[i] = min;

            if (min == u2) {
                index2++;
            }
            if (min == u3) {
                index3++;
            }
            if (min == u5) {
                index5++;
            }

        }

        return ugly[n - 1];
    }


}
