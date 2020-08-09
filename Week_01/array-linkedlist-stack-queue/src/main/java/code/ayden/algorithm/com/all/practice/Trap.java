package code.ayden.algorithm.com.all.practice;

import code.ayden.algorithm.com.stack.practice.ArrayStack;
import com.sun.prism.impl.TextureResourcePool;

import java.util.Stack;

/**
 * @description: 接雨水
 * @author: aydenwang
 * @create: 2020-08-02 21:22
 * @version: 1.0.0
 **/
public class Trap {

    /**
     * 按列求
     * 计算每一列的左，右最高的柱子，它们中最低者，决定了这一列能存储的雨水。如果最低比当前柱子低，则不能存储雨水
     * 计算雨水，用当前柱子和左右最高的高度差，乘以宽度（固定1），就是雨水面积
     * <p>
     * 时间复杂度：O(n²），遍历每一列需要 n，找出左边最高和右边最高的墙加起来刚好又是一个 n，所以是 n²
     * <p>
     * 空间复杂度：O(1）O(1）
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int sum = 0;
        /**
         * 左右两边的柱子都不能存储雨水
         */
        for (int i = 1; i < height.length - 1; i++) {
            int maxLeft = 0, maxRight = 0;
            for (int j = 0; j < i; j++) {
                maxLeft = Math.max(height[j], maxLeft);
            }
            for (int j = i + 1; j < height.length; j++) {
                maxRight = Math.max(height[j], maxRight);
            }
            int min = Math.min(maxLeft, maxRight);
            if (min > height[i]) {
                sum += (min - height[i]);
            }
        }
        return sum;
    }

    /**
     * 动态规划，DP
     * 仍然是按列求，但是我们不需要每根柱子都算一遍左边和右边的最高柱子，可以缓存起来
     * 按照动态规划思想，每根柱子的左边最高，等于前一根的左边最高和前一根高度比；右边类似
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)，用来保存每一列左边最高的墙和右边最高的墙。
     *
     * @param height
     * @return
     */
    public int trapDp(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int[] leftMaxArr = new int[height.length - 1];
        int[] rightMaxArr = new int[height.length];
        int sum = 0;
        //循环只需要从下标1开始，第一根柱子的左边没有柱子
        //同时，因为最后一根柱子不需要计算，所以循环到倒数第二根柱子就可以了
        for (int i = 1; i < height.length - 1; i++) {
            //注意：当i为0是，leftMaxArr[i - 1]即leftMaxArr[01的值为数组初始化的值0
            leftMaxArr[i] = Math.max(leftMaxArr[i - 1], height[i - 1]);
        }
        //循环从倒数第二根柱子开始，计算到第二根柱子
        for (int i = height.length - 2; i > 0; i--) {
            rightMaxArr[i] = Math.max(rightMaxArr[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(leftMaxArr[i], rightMaxArr[i]);
            if (min > height[i]) {
                sum += (min - height[i]);
            }
        }
        return sum;
    }

    /**
     * 动态规划，DP
     * 仍然是按列求，但是我们不需要每根柱子都算一遍左边和右边的最高柱子，可以缓存起来
     * 按照动态规划思想，每根柱子的左边最高，等于前一根的左边最高和前一根高度比；右边类似
     * <p>
     * 优化，第三个循环是从左到右遍历，和第一个循环顺序一样，可以把第一个循环的代码放到第三个循环，减少一个循环
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)，用来保存每一列左边最高的墙和右边最高的墙。
     *
     * @param height
     * @return
     */
    public int trapDpOpt(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int[] rightMaxArr = new int[height.length];
        int sum = 0;
        int leftMax = 0;

        //循环从倒数第二根柱子开始，计算到第二根柱子
        for (int i = height.length - 2; i > 0; i--) {
            rightMaxArr[i] = Math.max(rightMaxArr[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            //leftMax只是用了一次，无需保存
            leftMax = Math.max(leftMax, height[i - 1]);

            int min = Math.min(leftMax, rightMaxArr[i]);
            if (min > height[i]) {
                sum += (min - height[i]);
            }
        }
        return sum;
    }

    /**
     * 动态规划，DP，双指针
     * 仍然是按列求，但是我们不需要每根柱子都算一遍左边和右边的最高柱子，可以缓存起来
     * 按照动态规划思想，每根柱子的左边最高，等于前一根的左边最高和前一根高度比；右边类似
     * <p>
     * 优化，两个临时变量存储leftMax和rightMax，根据条件从左或者从右遍历
     * 时间复杂度：O(n)，虽然是while循环，但是每个元素只被循环一次
     * 空间复杂度：O(1)，不需要额外的数组
     *
     * @param height
     * @return
     */
    public int trapDpDoublePoint(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        //总面积
        int sum = 0;
        //左边最大
        int leftMax = 0;
        //右边最大
        int rightMax = 0;
        //左边遍历下标，从0开始，因为要计算第一根柱子的高度
        int left = 0;
        //右边遍历下标，从最后一个开始，因为要计算最后一根柱子高度
        int right = height.length - 1;
        // 从左到右遍历的写法
        while (left <= right) {
            if (leftMax <= rightMax) {
                //对于当前柱子来说，左边最高柱子最高是可信的，但是右边最高不一定，有可能有更高的柱子出现。所以当左边最高柱子高度小于右边柱子高度时，已经可以计算当前柱子能容纳的雨水容量了
                if (leftMax > height[left]) {
                    sum += (leftMax - height[left]);
                } else {
                    leftMax = height[left];
                }
                left++;
            } else {
                if (rightMax > height[right]) {
                    sum += (rightMax - height[right]);
                } else {
                    rightMax = height[right];
                }
                right--;
            }
        }
        return sum;
    }

    public int trapStack(int[] height) {
        Stack<Integer> stack = new Stack();
        int sumArea = 0;
        for (int current = 0; current < height.length; current++) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int top1 = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int top2 = stack.peek();
                int width = current - top2 - 1;

                int high = Math.min(height[current], height[top2]) - height[top1];
                int area = width * high;
                sumArea += area;
            }
            stack.push(current);
        }
        return sumArea;
    }


}
