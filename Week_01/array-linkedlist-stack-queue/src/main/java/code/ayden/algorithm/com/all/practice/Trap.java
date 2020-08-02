package code.ayden.algorithm.com.all.practice;

/**
 * @description: 接雨水
 * @author: aydenwang@tencent.com
 * @create: 2020-08-02 21:22
 * @version: 1.0.0
 **/
public class Trap {

    /**
     * 按列求
     * 计算每一列的左，右最高的柱子，它们中最低者，决定了这一列能存储的雨水。如果最低比当前柱子低，则不能存储雨水
     * 计算雨水，用当前柱子和左右最高的高度差，乘以宽度（固定1），就是雨水面积
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

}
